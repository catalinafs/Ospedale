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
public interface IPatientValidator extends IUserValidator{
    public Response validatePhone(long phone);
    public Response validateEmail(String email);
    public Response validateBirthdate(String birthdate);
}   
