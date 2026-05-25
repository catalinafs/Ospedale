/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.controllers.validators.IHospitalizationValidator;
import core.model.Appointment;
import core.model.Doctor;
import core.model.Hospitalization;
import core.model.HospitalizationStatus;
import core.model.IAppointmentStorage;
import core.model.IDoctorStorage;
import core.model.IHospitalizationStorage;
import core.model.IPatientStorage;
import core.model.Patient;
import core.model.RoomType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author briggoes
 */
public class HospitalizationController implements IHospitalizationOps {

    private final IHospitalizationStorage hospitalizationStorage;
    private final IPatientStorage patientStorage;
    private final IDoctorStorage doctorStorage;
    private final IAppointmentStorage appointmentStorage;
    private final IHospitalizationValidator validator;

    public HospitalizationController(IHospitalizationStorage hospitalizationStorage,
            IPatientStorage patientStorage, IDoctorStorage doctorStorage, 
            IAppointmentStorage appointmentStorage, 
            IHospitalizationValidator validator) {
        this.hospitalizationStorage = hospitalizationStorage;
        this.patientStorage = patientStorage;
        this.doctorStorage = doctorStorage;
        this.appointmentStorage = appointmentStorage;
        this.validator = validator;
    }

    @Override
    public Response requestHospitalization(long patientId, String reason, String doctorFullName, String estimatedDate, String roomType, String observations) {
        try {
            Patient patient = patientStorage.getPatient(patientId);
            if (patient == null) {
                return new Response("Patient not found.", Status.NOT_FOUND);
            }
            if (reason == null || reason.trim().isEmpty()) {
                return new Response("Reason is required.", Status.BAD_REQUEST);
            }
            Doctor doctor = doctorStorage.getDoctorByFullName(doctorFullName);
            if (doctor == null) {
                return new Response("Doctor not found.", Status.NOT_FOUND);
            }
            Response error = validator.validateAdmissionDate(estimatedDate);
            if (error != null) {
                return error;
            }
            LocalDate date = LocalDate.parse(estimatedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if (observations == null || observations.trim().isEmpty()) {
                return new Response("observations is required.", Status.BAD_REQUEST);
            }
            RoomType room = RoomType.valueOf(roomType);

            String hosp_id = hospitalizationStorage.generateHospitalizationId(patientId);
            Hospitalization hosp = new Hospitalization(hosp_id, patient, doctor, date, reason, room, observations);

            hospitalizationStorage.addHospitalization(hosp);
            patient.setHospitalization(hosp);
            doctor.getHospitalizations().add(hosp);

            HashMap<String, Object> data = new HashMap<>();
            data.put("hospitalizationId", hosp_id);
            data.put("date", date);
            data.put("doctor", doctor.getFirstname() + " " + doctor.getLastname());
            return new Response("Hospitalization requested successfully.", Status.CREATED, data);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Response approveHospitalization(String hospitalizationId, long doctorId) {
        try {
            Hospitalization hosp = hospitalizationStorage.getHospitalization(hospitalizationId);
            if (hosp == null) {
                return new Response("Hospitalization not found.", Status.NOT_FOUND);
            }
            Doctor doctor = doctorStorage.getDoctor(doctorId);
            if (doctor == null) {
                return new Response("Doctor not found.", Status.NOT_FOUND);
            }
            if (hosp.getDoctor().getId() != doctorId) {
                return new Response("You are not the doctor of this hospitalization.", Status.UNAUTHORIZED);
            }
            if (hosp.getStatus() != HospitalizationStatus.REQUESTED) {
                return new Response("Hospitalization cannot be approved.", Status.BAD_REQUEST);
            }
            hosp.setStatus(HospitalizationStatus.ONGOING);
            HashMap<String, Object> data = new HashMap<>();
            data.put("hospitalizationId", hospitalizationId);
            data.put("status", HospitalizationStatus.ONGOING);
            return new Response("Hospitalization approved successfully.", Status.OK, data);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Response rejectHospitalization(String hospitalizationId, long doctorId) {
        try {
            Hospitalization hosp = hospitalizationStorage.getHospitalization(hospitalizationId);
            if (hosp == null) {
                return new Response("Hospitalization not found.", Status.NOT_FOUND);
            }
            Doctor doctor = doctorStorage.getDoctor(doctorId);
            if (doctor == null) {
                return new Response("Doctor not found.", Status.NOT_FOUND);
            }
            if (hosp.getDoctor().getId() != doctorId) {
                return new Response("You are not the doctor of this hospitalization.", Status.UNAUTHORIZED);
            }
            if (hosp.getStatus() != HospitalizationStatus.REQUESTED) {
                return new Response("Hospitalization cannot be rejected.", Status.BAD_REQUEST);
            }
            hosp.setStatus(HospitalizationStatus.CANCELED);
            HashMap<String, Object> data = new HashMap<>();
            data.put("hospitalizationId", hospitalizationId);
            data.put("status", HospitalizationStatus.CANCELED);
            return new Response("Hospitalization rejected successfully.", Status.OK, data);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Response completeFromAppointment(String appointmentId, long doctorId, String hospitalizationId) {
        try {
            Appointment appointment = appointmentStorage.getAppointment(appointmentId);
            if (appointment == null) {
                return new Response("Appointment not found.", Status.NOT_FOUND);
            }
            if (appointment.getDoctor().getId() != doctorId) {
                return new Response("You are not the doctor of this appointment.", Status.UNAUTHORIZED);
            }
            Hospitalization hosp = hospitalizationStorage.getHospitalization(hospitalizationId);
            if (hosp == null) {
                return new Response("Hospitalization not found.", Status.NOT_FOUND);
            }
            if (hosp.getStatus() != HospitalizationStatus.ONGOING) {
                return new Response("Hospitalization must be ONGOING to complete.", Status.BAD_REQUEST);
            }
            hosp.setStatus(HospitalizationStatus.COMPLETED);
            HashMap<String, Object> data = new HashMap<>();
            data.put("hospitalizationId", hospitalizationId);
            data.put("status", HospitalizationStatus.COMPLETED);
            return new Response("Hospitalization completed successfully.", Status.OK, data);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Response getPatientHospitalizations(long patientId) {
        try {
            ArrayList<Hospitalization> patientHosp = new ArrayList<>();
            for (Hospitalization h : hospitalizationStorage.getAllHospitalizations()) {
                if (h.getPatient().getId() == patientId) {
                    patientHosp.add(h);
                }
            }
            HashMap<String, Object> data = new HashMap<>();
            data.put("hospitalizations", patientHosp);
            return new Response("Hospitalizations found.", Status.OK, data);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

}
