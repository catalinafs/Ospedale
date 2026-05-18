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
public interface IAppointmentQuery {
    public Response getPatientAppointments(long patientId);
    public Response getDoctorAppointments(long doctorId);
    public Response getDoctorPending(long doctorId);
}
