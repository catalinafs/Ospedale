/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.controllers.validators.IHospitalizationValidator;
import core.model.Doctor;
import core.model.Hospitalization;
import core.model.IDoctorStorage;
import core.model.IHospitalizationStorage;
import core.model.IPatientStorage;
import core.model.Patient;
import core.model.RoomType;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author briggoes
 */
public class HospitalizationController implements IHospitalizationOps {

    private final IHospitalizationStorage hospitalizationStorage;
    private final IPatientStorage patientStorage;
    private final IDoctorStorage doctorStorage;
    private final IHospitalizationValidator validator;

    public HospitalizationController(IHospitalizationStorage hospitalizationStorage, IPatientStorage patientStorage, IDoctorStorage doctorStorage, IHospitalizationValidator validator) {
        this.hospitalizationStorage = hospitalizationStorage;
        this.patientStorage = patientStorage;
        this.doctorStorage = doctorStorage;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Response rejectHospitalization(String hospitalizationId, long doctorId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Response completeFromAppointment(String appointmentId, long doctorId, String hospitalizationId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Response getPatientHospitalizations(long patientId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
