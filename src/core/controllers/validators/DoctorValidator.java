/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.validators;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.model.Specialty;

/**
 *
 * @author daniel
 */
public class DoctorValidator implements IDoctorValidator{
    @Override
    public Response validateUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            return new Response("Username is required.", Status.BAD_REQUEST);
        }
        return null;
    }
    
    @Override
    public Response validatePassword(String password, String passwordConfirm) {
        if (password == null || password.trim().isEmpty()) {
            return new Response("Password is required.", Status.BAD_REQUEST);
        }
        if (passwordConfirm == null || !password.equals(passwordConfirm)) {
            return new Response("Passwords do not match.", Status.BAD_REQUEST);
        }
        return null;
    }
    
    @Override
    public Response validateLicence(String licence) {
        if (licence == null || licence.length() != 16) {
            return new Response("Licence must follow format L-XXXXXXXXXX MTL.", Status.BAD_REQUEST);
        }
        if (!licence.startsWith("L-") || !licence.endsWith(" MTL")) {
            return new Response("Licence must follow format L-XXXXXXXXXX MTL.", Status.BAD_REQUEST);
        }
        String numbers = licence.substring(2, 12);
        if (!numbers.matches("\\d{10}")) {
            return new Response("Licence must follow format L-XXXXXXXXXX MTL.", Status.BAD_REQUEST);
        }
        return null;
    }
    
    @Override
    public Response validateOffice(String office) {
        if (office == null || office.length() != 5) {
            return new Response("Office must follow format O-XXX.", Status.BAD_REQUEST);
        }
        if (!office.startsWith("O-")) {
            return new Response("Office must follow format O-XXX.", Status.BAD_REQUEST);
        }
        String numbers = office.substring(2);
        if (!numbers.matches("\\d{3}")) {
            return new Response("Office must follow format O-XXX.", Status.BAD_REQUEST);
        }
        return null;
    }
    
    @Override
    public Response validateSpecialty(Specialty specialty) {
        if (specialty == null) {
            return new Response("Specialty is required.", Status.BAD_REQUEST);
        }
        return null;
    }
    
    @Override
    public Response validateId(long id){
        if(id <= 0 || id > 999999999999L){
            return new Response("ID muste be greater than 0 and have 12 digits.", Status.BAD_REQUEST);
        }
        return null;
    }
}
