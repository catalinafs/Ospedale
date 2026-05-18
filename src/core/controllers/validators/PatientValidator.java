/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.validators;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import java.time.LocalDate;

/**
 *
 * @author daniel
 */
public class PatientValidator implements IPatientValidator {
    @Override
    public Response validateUsername(String username){
        if(username == null || username.trim().isEmpty()){
            return new Response("Username is required.", Status.BAD_REQUEST);
        }
        return null;
    }
    
    @Override
    public Response validatePassword(String password, String passwordConfirm){
        if(password == null || password.trim().isEmpty()){
            return new Response("Password is required.", Status.BAD_REQUEST);
        }
        if(passwordConfirm == null || !password.equals(passwordConfirm)){
            return new Response("Passwords do not match.", Status.BAD_REQUEST);
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
    
    @Override
    public Response validatePhone(long phone) {
        if (phone < 1000000000L || phone > 9999999999L) {
            return new Response("Phone must have exactly 10 digits.", Status.BAD_REQUEST);
        }
        return null;
    }
    
    @Override
    public Response validateEmail(String email) {
        if (email == null || !email.contains("@") || !email.endsWith(".com")) {
            return new Response("Email must be valid (format: xxxxx@xxxxx.com).", Status.BAD_REQUEST);
        }
        String[] parts = email.split("@");
        if (parts.length != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return new Response("Email must be valid (format: xxxxx@xxxxx.com).", Status.BAD_REQUEST);
        }
        return null;
    }
    
    @Override
    public Response validateBirthdate(String birthdate) {
        if (birthdate == null || birthdate.length() != 10) {
            return new Response("Birthdate must be valid (format: YYYY-MM-DD).", Status.BAD_REQUEST);
        }
        
        if (birthdate.charAt(4) != '-' || birthdate.charAt(7) != '-') {
            return new Response("Birthdate must be valid (format: YYYY-MM-DD).", Status.BAD_REQUEST);
        }
        
        try {
            int year = Integer.parseInt(birthdate.substring(0, 4));
            int month = Integer.parseInt(birthdate.substring(5, 7));
            int day = Integer.parseInt(birthdate.substring(8, 10));
            
            if (month < 1 || month > 12 || day < 1 || day > 31) {
                return new Response("Birthdate must be valid (format: YYYY-MM-DD).", Status.BAD_REQUEST);
            }
            
            if (year > LocalDate.now().getYear()) {
                return new Response("Birthdate cannot be in the future.", Status.BAD_REQUEST);
            }
        } catch (NumberFormatException e) {
            return new Response("Birthdate must be valid (format: YYYY-MM-DD).", Status.BAD_REQUEST);
        }
        
        return null;
    }
}
