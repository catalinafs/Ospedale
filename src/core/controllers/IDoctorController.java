/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.model.Specialty;

/**
 *
 * @author daniel
 */
public interface IDoctorController {
    public Response register(
        long id, 
        String username, 
        String firstname, 
        String lastname,
        String password, 
        String passwordConfirm, 
        Specialty specialty,
        String licenceNumber, 
        String assignedOffice
    );
    
    public Response update(
        long id, 
        String username, 
        String firstname, 
        String lastname,
        String password, 
        String passwordConfirm,
        String licenceNumber, 
        String assignedOffice
    );
    
    public Response getDoctor(long id);
    
    public Response getAllDoctors();
    
    public Response getDoctorsBySpecialty(Specialty specialty);
}
