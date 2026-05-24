/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.controllers.validators;

import core.controllers.utils.Response;
import core.model.Specialty;

/**
 *
 * @author daniel
 */
public interface IDoctorValidator extends IUserValidator{
    public Response validateLicence(String licence);
    public Response validateOffice(String office);
    public Response validateSpecialty(String specialty);
}
