/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;

/**
 *
 * @author daniel
 */
public interface IHospitalizationOps {
    Response requestHospitalization(
        long patientId,
        String reason,
        long doctorId,
        String estimatedDate,
        String roomType,
        String observations
    );
        Response requestHospitalization(
        long patientId,
        String reason,
        String doctorFullName,
        String estimatedDate,
        String roomType,
        String observations
    );
    Response approveHospitalization(String hospitalizationId, long doctorId);
    Response rejectHospitalization(String hospitalizationId, long doctorId);
    Response completeFromAppointment(String appointmentId, long doctorId, String hospitalizationId);
    Response createFromAppointment(String appointmentId, long doctorId, String reason, String roomType, String observations);
    Response getPatientHospitalizations(long patientId);
    Response getDoctorHospitalizations(long doctorId);
}
