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
public interface IPrescription {
    public Response prescribeMedication(
        String appointmentId,
        long doctorId,
        String medication,
        String dose,
        String administrationRoute,
        String treatmentDuration,
        String additionalInstructions,
        String frequency
    );
}
