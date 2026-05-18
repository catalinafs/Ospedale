/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.controllers.validators.IPatientValidator;
import core.model.IPatientStorage;
import core.model.Patient;
import core.model.PatientStorage;
import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author briggoes
 */
public class PatientController implements IPatientController{
    private final IPatientStorage storage;
    private final IPatientValidator validator;
    
    public PatientController(IPatientStorage storage, IPatientValidator validator) {
        this.storage = storage;
        this.validator = validator;
    }
    
    @Override
    public Response register(long id, String username, String firstname,
            String lastname, String password, String passwordConfirm, String email,
            LocalDate birthdate, boolean gender, long phone, String address) {
        Response error = validator.validateId(id);
        if (error != null) return error;
        error = validator.validateUsername(username);
        if (error != null) return error;
        error = validator.validatePassword(password, passwordConfirm);
        if (error != null) return error;
        error = validator.validatePhone(phone);
        if (error != null) return error;
        error = validator.validateEmail(email);
        if (error != null) return error;
        error = validator.validateBirthdate(birthdate.toString());
        if (error != null) return error;
        if (firstname == null || firstname.trim().isEmpty()) {
            return new Response("Firstname is required.", Status.BAD_REQUEST);
        }
        if (lastname == null || lastname.trim().isEmpty()) {
            return new Response("Lastname is required.", Status.BAD_REQUEST);
        }
        if (address == null || address.trim().isEmpty()) {
            return new Response("Address is required.", Status.BAD_REQUEST);
        }
        if (storage.getPatient(id) != null) {
            return new Response("Patient id already exists.", Status.CONFLICT);
        }
        if (storage.getPatientByUsername(username) != null) {
            return new Response("Patient username already exists.", Status.CONFLICT);
        }
        Patient patient = new Patient(id, username, firstname, lastname, password, 
                email, birthdate, gender, phone, address);
        
        if (!storage.addPatient(patient)) {
            return new Response("Patient id already exists.", Status.CONFLICT);
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", patient.getId());
        data.put("username", patient.getUsername());
        data.put("firstname", patient.getFirstname());
        data.put("lastname", patient.getLastname());
        return new Response("Registration successful.", Status.CREATED, data);
    }
    
    @Override
    public Response update(long id, String username, String firstname,
            String lastname, String password, String passwordConfirm, String email,
            LocalDate birthdate, boolean gender, long phone, String address) {
        Patient existingPatient = storage.getPatient(id);
        if (existingPatient == null) {
            return new Response("Patient not found.", Status.NOT_FOUND);
        }
        Response error = validator.validateUsername(username);
        if (error != null) return error;
        error = validator.validatePassword(password, passwordConfirm);
        if (error != null) return error;
        error = validator.validatePhone(phone);
        if (error != null) return error;
        error = validator.validateEmail(email);
        if (error != null) return error;
        error = validator.validateBirthdate(birthdate.toString());
        if (error != null) return error;
        if (firstname == null || firstname.trim().isEmpty()) {
            return new Response("Firstname is required.", Status.BAD_REQUEST);
        }
        if (lastname == null || lastname.trim().isEmpty()) {
            return new Response("Lastname is required.", Status.BAD_REQUEST);
        }
        if (address == null || address.trim().isEmpty()) {
            return new Response("Address is required.", Status.BAD_REQUEST);
        }
        Patient patientWithUsername = storage.getPatientByUsername(username);
        if (patientWithUsername != null && patientWithUsername.getId() != id) {
            return new Response("Patient username already exists.", Status.CONFLICT);
        }
        if (!storage.updatePatient(id, username, firstname, lastname, password, 
                email, birthdate, gender, phone, address)) {
            return new Response("Patient not found.", Status.NOT_FOUND);
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("username", username);
        return new Response("Update successful.", Status.OK, data);
    }
    
    @Override
    public Response getPatient(long id) {
        Patient patient = storage.getPatient(id);
        if (patient == null) {
            return new Response("Patient not found.", Status.NOT_FOUND);
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", patient.getId());
        data.put("username", patient.getUsername());
        data.put("firstname", patient.getFirstname());
        data.put("lastname", patient.getLastname());
        data.put("email", patient.getEmail());
        data.put("birthdate", patient.getBirthdate().toString());
        data.put("gender", patient.isGender());
        data.put("phone", patient.getPhone());
        data.put("address", patient.getAddress());
        return new Response("Patient found.", Status.OK, data);
    }
}
