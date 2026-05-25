/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.controllers.validators;

import core.controllers.utils.Response;

/**
 *
 * @author daniel
 */
public interface IPrescriptionValidator {
    Response validate(String medicationName, String dose, String administrationRoute,
                      String treatmentDuration, String additionalInstructions, String frequency);
}
