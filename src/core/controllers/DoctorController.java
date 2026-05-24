/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.controllers.validators.IDoctorValidator;
import core.model.Doctor;
import core.model.IDoctorStorage;
import core.model.Specialty;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 *
 * @author briggoes
 */
public class DoctorController implements IDoctorController {

    private final IDoctorStorage storage;
    private final IDoctorValidator validator;

    public DoctorController(IDoctorStorage storage, IDoctorValidator validator) {
        this.storage = storage;
        this.validator = validator;
    }

    @Override
    public Response register(long id, String username, String firstname, String lastname, String password, String passwordConfirm, Specialty specialty, String licenceNumber, String assignedOffice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Response update(long id, String username, String firstname, String lastname, String password, String passwordConfirm, String licenceNumber, String assignedOffice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Response getDoctor(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Response getAllDoctors() {
        try {
            var doctors = storage.getAllDoctors();
            HashMap<String, Object> map = new HashMap();
            
            for (Doctor doc : doctors) {
                map.put(String.valueOf(doc.getId()), doc);
            }
            
            return new Response("Doctors found.", Status.OK, map);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Response getDoctorsBySpecialty(Specialty specialty) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
