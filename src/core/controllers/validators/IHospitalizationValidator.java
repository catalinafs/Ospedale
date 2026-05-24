/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.validators;

import core.controllers.utils.Response;

/**
 *
 * @author briggoes
 */
public interface IHospitalizationValidator {
    public Response validateAdmissionDate(String date);
}
