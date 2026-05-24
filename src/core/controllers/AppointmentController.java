/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.controllers.validators.IAppointmentValidator;
import core.model.Appointment;
import core.model.AppointmentStatus;
import core.model.Doctor;
import core.model.IAppointmentStorage;
import core.model.IDoctorStorage;
import core.model.IPatientStorage;
import core.model.Patient;
import core.model.Specialty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author briggoes
 */
public class AppointmentController implements IAppointmentOps, IAppointmentQuery {

    private final IAppointmentStorage appointmentStorage;
    private final IPatientStorage patientStorage;
    private final IDoctorStorage doctorStorage;
    private final IAppointmentValidator validator;

    public AppointmentController(
            IAppointmentStorage appointmentStorage,
            IPatientStorage patientStorage,
            IDoctorStorage doctorStorage,
            IAppointmentValidator validator
    ) {
        this.appointmentStorage = appointmentStorage;
        this.patientStorage = patientStorage;
        this.doctorStorage = doctorStorage;
        this.validator = validator;
    }

    @Override
    public Response requestAppointment(long patientId, String date, String time, int type, String reason, String doctorOrSpecialty, boolean isSpecialty) {
        try {
            Patient patient = patientStorage.getPatient(patientId);
            if (patient == null) {
                return new Response("Patient not found.", Status.NOT_FOUND);
            }

            Response error = validator.validateDateTime(date, time);
            if (error != null) {
                return error;
            }

            if (reason == null || reason.trim().isEmpty()) {
                return new Response("Reason is required.", Status.BAD_REQUEST);
            }

            Specialty specialty = null;
            Doctor doctor = null;

            if (isSpecialty) {
                specialty = Specialty.valueOf(doctorOrSpecialty.toUpperCase().replace(" & ", "_"));
                doctor = appointmentStorage.findAvailableDoctor(specialty, date, time);
                if (doctor == null) {
                    return new Response("No doctors available for that specialty at the given time.", Status.CONFLICT);
                }
            } else {
                long docId = Long.parseLong(doctorOrSpecialty);
                doctor = doctorStorage.getDoctor(docId);
                if (doctor == null) {
                    return new Response("Doctor not found.", Status.NOT_FOUND);
                }
                if (!appointmentStorage.isDoctorAvailable(docId, date, time)) {
                    return new Response("Doctor is unavaialbe at the given time.", Status.CONFLICT);
                }
            }

            String appointmentId = appointmentStorage.generateAppointmentId(patientId);
            LocalDateTime dateTime = LocalDateTime.of(
                    LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"))
            );
            
            Appointment appointment = new Appointment(
                    appointmentId, patient, doctor, doctor.getSpecialty(),
                    dateTime, reason, "consultation".equals(type)
            );
            
            appointmentStorage.addAppointment(appointment);
            patient.getAppointments().add(appointment);
            doctor.getAppointments().add(appointment);
            
            HashMap<String, Object> data = new HashMap<>();
            data.put("appointmentId", appointmentId);
            data.put("date", date);
            data.put("time", time);
            data.put("doctor", doctor.getFirstname() + " " + doctor.getLastname());
            return new Response("Appointment requested successfully.", Status.CREATED, data);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Response acceptAppointment(String appointmentId, long doctorId) {
        Appointment appointment = appointmentStorage.getAppointment(appointmentId);
        if (appointment == null) {
            return new Response("Appointment not found.", Status.NOT_FOUND);
        }
        Doctor doctor = doctorStorage.getDoctor(doctorId);
        if (doctor == null) {
            return new Response("Doctor not found.", Status.NOT_FOUND);
        }
        if (appointment.getDoctor().getId() != doctorId) {
            return new Response("You are not the doctor of this appointment.", Status.UNAUTHORIZED);
        }
        if (appointment.getStatus() != AppointmentStatus.REQUESTED) {
            return new Response("Appointment cannot be accepted.", Status.BAD_REQUEST);
        }
        appointment.setStatus(AppointmentStatus.PENDING);
        return new Response("Appointment accepted.", Status.OK);
    }

    @Override
    public Response completeAppointment(String appointmentId, long doctorId) {
        Appointment appointment = appointmentStorage.getAppointment(appointmentId);
        if (appointment == null) {
            return new Response("Appointment not found.", Status.NOT_FOUND);
        }
        Doctor doctor = doctorStorage.getDoctor(doctorId);
        if (doctor == null) {
            return new Response("Doctor not found.", Status.NOT_FOUND);
        }
        if (appointment.getDoctor().getId() != doctorId) {
            return new Response("You are not the doctor of this appointment.", Status.UNAUTHORIZED);
        }
        if (appointment.getStatus() != AppointmentStatus.PENDING) {
            return new Response("Appointment cannot be completed.", Status.BAD_REQUEST);
        }
        appointment.setStatus(AppointmentStatus.COMPLETED);
        return new Response("Appointment completed.", Status.OK);
    }

    @Override
    public Response cancelAppointment(String appointmentId, long patientId) {
        Appointment appointment = appointmentStorage.getAppointment(appointmentId);
        if (appointment == null) {
            return new Response("Appointment not found.", Status.NOT_FOUND);
        }
        if (appointment.getPatient().getId() != patientId) {
            return new Response("You are not the patient of this appointment.", Status.UNAUTHORIZED);
        }
        if (appointment.getStatus() == AppointmentStatus.COMPLETED) {
            return new Response("Cannot cancel a completed appointment.", Status.BAD_REQUEST);
        }
        appointment.setStatus(AppointmentStatus.CANCELED);
        return new Response("Appointment canceled.", Status.OK);
    }

    @Override
    public Response rescheduleAppointment(String appointmentId, long doctorId, String newTime, String reason) {
        Appointment appointment = appointmentStorage.getAppointment(appointmentId);
        if (appointment == null) {
            return new Response("Appointment not found.", Status.NOT_FOUND);
        }
        Doctor doctor = doctorStorage.getDoctor(doctorId);
        if (doctor == null) {
            return new Response("Doctor not found.", Status.NOT_FOUND);
        }
        if (appointment.getDoctor().getId() != doctorId) {
            return new Response("You are not the doctor of this appointment.", Status.UNAUTHORIZED);
        }
        String existingDate = appointment.getDatetime().toLocalDate().toString();
        Response timeError = validator.validateDateTime(existingDate, newTime);
        if (timeError != null) {
            return timeError;
        }
        if (!appointmentStorage.isDoctorAvailable(doctorId, existingDate, newTime)) {
            return new Response("Doctor is not available at the new time.", Status.BAD_REQUEST);
        }
        String oldTime = appointment.getDatetime().toLocalTime().toString();
        if (reason != null && !reason.trim().isEmpty()) {
            appointment.setReason(appointment.getReason() + " | Rescheduled: " + reason);
        }
        LocalTime newLocalTime = LocalTime.parse(newTime, DateTimeFormatter.ofPattern("HH:mm"));
        LocalDateTime newDateTime = appointment.getDatetime().with(newLocalTime);
        appointment.setDatetime(newDateTime);
        HashMap<String, Object> data = new HashMap<>();
        data.put("oldTime", oldTime);
        data.put("newTime", newTime);
        return new Response("Appointment rescheduled.", Status.OK, data);
    }

    @Override
    public Response getPatientAppointments(long patientId) {
        Patient patient = patientStorage.getPatient(patientId);
        if (patient == null) {
            return new Response("Patient not found.", Status.NOT_FOUND);
        }
        ArrayList<Appointment> appointments = patient.getAppointments();
        appointments.sort((a, b) -> b.getDatetime().compareTo(a.getDatetime()));
        ArrayList<HashMap<String, Object>> appointmentList = new ArrayList<>();
        for (Appointment appt : appointments) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", appt.getId());
            data.put("date", appt.getDatetime().toLocalDate().toString());
            data.put("time", appt.getDatetime().toLocalTime().toString().substring(0, 5));
            data.put("doctor", appt.getDoctor().getFirstname() + " " + appt.getDoctor().getLastname());
            data.put("specialty", appt.getSpecialty().toString());
            data.put("status", appt.getStatus().toString());
            data.put("reason", appt.getReason());
            appointmentList.add(data);
        }
        HashMap<String, Object> result = new HashMap<>();
        result.put("appointments", appointmentList);
        return new Response("Appointments retrieved.", Status.OK, result);
    }

    @Override
    public Response getDoctorAppointments(long doctorId) {
        Doctor doctor = doctorStorage.getDoctor(doctorId);
        if (doctor == null) {
            return new Response("Doctor not found.", Status.NOT_FOUND);
        }
        ArrayList<Appointment> appointments = doctor.getAppointments();
        appointments.sort((a, b) -> b.getDatetime().compareTo(a.getDatetime()));
        ArrayList<HashMap<String, Object>> appointmentList = new ArrayList<>();
        for (Appointment appt : appointments) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", appt.getId());
            data.put("date", appt.getDatetime().toLocalDate().toString());
            data.put("time", appt.getDatetime().toLocalTime().toString().substring(0, 5));
            data.put("patient", appt.getPatient().getFirstname() + " " + appt.getPatient().getLastname());
            data.put("specialty", appt.getSpecialty().toString());
            data.put("status", appt.getStatus().toString());
            data.put("reason", appt.getReason());
            appointmentList.add(data);
        }
        HashMap<String, Object> result = new HashMap<>();
        result.put("appointments", appointmentList);
        return new Response("Appointments retrieved.", Status.OK, result);
    }

    @Override
    public Response getDoctorPending(long doctorId) {
        Doctor doctor = doctorStorage.getDoctor(doctorId);
        if (doctor == null) {
            return new Response("Doctor not found.", Status.NOT_FOUND);
        }
        ArrayList<Appointment> appointments = doctor.getAppointments();
        appointments.removeIf(appt -> appt.getStatus() != AppointmentStatus.PENDING);
        appointments.sort((a, b) -> b.getDatetime().compareTo(a.getDatetime()));
        ArrayList<HashMap<String, Object>> appointmentList = new ArrayList<>();
        for (Appointment appt : appointments) {
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", appt.getId());
            data.put("date", appt.getDatetime().toLocalDate().toString());
            data.put("time", appt.getDatetime().toLocalTime().toString().substring(0, 5));
            data.put("patient", appt.getPatient().getFirstname() + " " + appt.getPatient().getLastname());
            data.put("specialty", appt.getSpecialty().toString());
            data.put("status", appt.getStatus().toString());
            data.put("reason", appt.getReason());
            appointmentList.add(data);
        }
        HashMap<String, Object> result = new HashMap<>();
        result.put("appointments", appointmentList);
        return new Response("Pending appointments retrieved.", Status.OK, result);
    }
}
