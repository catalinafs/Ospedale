/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import java.time.LocalDate;

/**
 *
 * @author daniel
 */
public interface IPatientController {
    public Response register(
        long id, 
        String username, 
        String firstname, 
        String lastname,
        String password, 
        String passwordConfirm, 
        String email,
        LocalDate birthdate, 
        boolean gender, 
        long phone, 
        String address
    );
    
    public Response update(
            long id, String username, String firstname, String lastname,
            String password, 
            String passwordConfirm, 
            String email,
            LocalDate birthdate, 
            boolean gender, 
            long phone, 
            String address
    );
    
    public Response getPatient(long id);
}
