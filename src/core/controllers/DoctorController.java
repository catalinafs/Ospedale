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
import core.model.UserStorage;
import core.model.persistence.IUserPersistence;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author briggoes
 */
public class DoctorController implements IDoctorController {
    private final IDoctorStorage storage;
    private final IDoctorValidator validator;
    private final IUserPersistence persistence;
    
    public DoctorController(IDoctorStorage storage, IDoctorValidator validator, IUserPersistence persistence) {
        this.storage = storage;
        this.validator = validator;
        this.persistence = persistence;
    }
    
    @Override
    public Response register(long id, String username, String firstname, String lastname, String password, String passwordConfirm, Specialty specialty, String licenceNumber, String assignedOffice) {
        try {
            if (firstname == null || firstname.trim().isEmpty()) {
                return new Response("Firstname is required.", Status.BAD_REQUEST);
            }
            if (lastname == null || lastname.trim().isEmpty()) {
                return new Response("Lastname is required.", Status.BAD_REQUEST);
            }
            Response error = validator.validateId(String.valueOf(id));
            if (error != null) return error;
            if (storage.getDoctor(id) != null) {
                return new Response("Doctor with this ID already exists.", Status.CONFLICT);
            }
            error = validator.validateSpecialty(String.valueOf(specialty));
            if (error != null) return error;
            error = validator.validateLicence(licenceNumber);
            if (error != null) return error;
            for (Doctor d : storage.getAllDoctors()) {
                if (d.getLicenceNumber().equals(licenceNumber.trim())) {
                    return new Response("Licence number already in use.", Status.CONFLICT);
                }
            }  
            error = validator.validateOffice(assignedOffice);
            if (error != null) return error;
            error = validator.validateUsername(username);
            if (error != null) return error;
            if (storage.getDoctorByUsername(username.trim()) != null) {
                return new Response("Username already in use.", Status.CONFLICT);
            }
            error = validator.validatePassword(password, passwordConfirm);
            if (error != null) return error;
            Doctor doctor = new Doctor(id, username, firstname, lastname, password, specialty, licenceNumber, assignedOffice);
            storage.addDoctor(doctor);
            persistence.save(UserStorage.getInstance());
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", id);
            data.put("username", username);
            data.put("firstname", firstname);
            data.put("lastname", lastname);
            return new Response("Doctor registered successfully.", Status.CREATED, data);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @Override
    public Response update(long id, String username, String firstname, String lastname, String password, String passwordConfirm, String specialty, String licenseNumber, String assignedOffice) {
        try {
            if (storage.getDoctor(id) == null) {
                return new Response("Doctor not found.", Status.NOT_FOUND);
            }
            if (specialty != null && !specialty.trim().isEmpty()) {
                Response error = validator.validateSpecialty(specialty);
                if (error != null) {
                    return error;
                }
            }
            if (licenseNumber != null && !licenseNumber.trim().isEmpty()) {
                Response error = validator.validateLicence(licenseNumber);
                if (error != null) {
                    return error;
                }
            }
            if (assignedOffice != null && !assignedOffice.trim().isEmpty()) {
                Response error = validator.validateOffice(assignedOffice);
                if (error != null) {
                    return error;
                }
            }
            if (username != null && !username.trim().isEmpty()) {
                Doctor docWithUsername = storage.getDoctorByUsername(username.trim());
                if (docWithUsername != null && docWithUsername.getId() != id) {
                    return new Response("Username already in use.", Status.CONFLICT);
                }
            }
            boolean passwordProvided = password != null && !password.trim().isEmpty();
            boolean confirmationProvided = passwordConfirm != null && !passwordConfirm.trim().isEmpty();
            if (passwordProvided || confirmationProvided) {
                if (!passwordProvided || !confirmationProvided) {
                    return new Response(
                            "Password and confirmation must both be provided to change the password.",
                            Status.BAD_REQUEST);
                }
                Response error = validator.validatePassword(password, passwordConfirm);
                if (error != null) {
                    return error;
                }
            }
            if (!storage.updateDoctor(id, username, firstname, lastname, password, licenseNumber, assignedOffice)) {
                return new Response("Doctor not found.", Status.NOT_FOUND);
            }
            persistence.save(UserStorage.getInstance());
            Doctor updated = storage.getDoctor(id);
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", id);
            data.put("username", updated.getUsername());
            data.put("firstname", updated.getFirstname());
            data.put("lastname", updated.getLastname());
            return new Response("Update successful.", Status.OK, data);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    @Override
    public Response getDoctor(long id) {
        try {
            Doctor doctor = storage.getDoctor(id);
            if (doctor == null) {
                return new Response("Doctor not found.", Status.NOT_FOUND);
            }
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", doctor.getId());
            data.put("username", doctor.getUsername());
            data.put("firstname", doctor.getFirstname());
            data.put("lastname", doctor.getLastname());
            data.put("specialty", doctor.getSpecialty());
            data.put("licenceNumber", doctor.getLicenceNumber());
            data.put("assignedOffice", doctor.getAssignedOffice());
            return new Response("Doctor found.", Status.OK, data);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
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
        try {
            ArrayList<Doctor> filtered = new ArrayList<>();
            for (Doctor d : storage.getAllDoctors()) {
                if (d.getSpecialty() == specialty) {
                    filtered.add(d);
                }
            }
            HashMap<String, Object> data = new HashMap<>();
            data.put("doctors", filtered);
            return new Response("Doctors found.", Status.OK, data);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
