/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.validators;

import core.controllers.utils.Response;
import core.controllers.utils.Status;

/**
 *
 * @author daniel
 */
public class PrescriptionValidator implements IPrescriptionValidator{
    @Override
    public Response validate(String medicationName, String doseStr, String administrationRoute,
                              String treatmentDurationStr, String additionalInstructions, String frequencyStr) {
        if (medicationName == null || medicationName.trim().isEmpty()) {
            return new Response("Medication name is required.", Status.BAD_REQUEST);
        }
        if (administrationRoute == null || administrationRoute.trim().isEmpty()) {
            return new Response("Administration route is required.", Status.BAD_REQUEST);
        }
        try {
            double dose = Double.parseDouble(doseStr);
            if (dose <= 0) {
                return new Response("Dose must be greater than zero.", Status.BAD_REQUEST);
            }
        } catch (NumberFormatException e) {
            return new Response("Invalid dose format.", Status.BAD_REQUEST);
        }
        try {
            int duration = Integer.parseInt(treatmentDurationStr);
            if (duration <= 0) {
                return new Response("Treatment duration must be greater than zero.", Status.BAD_REQUEST);
            }
        } catch (NumberFormatException e) {
            return new Response("Invalid treatment duration format.", Status.BAD_REQUEST);
        }
        try {
            int freq = Integer.parseInt(frequencyStr);
            if (freq <= 0) {
                return new Response("Frequency must be greater than zero.", Status.BAD_REQUEST);
            }
        } catch (NumberFormatException e) {
            return new Response("Invalid frequency format.", Status.BAD_REQUEST);
        }
        return null;
    }
}
