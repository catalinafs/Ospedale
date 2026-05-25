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
import java.util.ArrayList;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Response getAllDoctors() {
        try {
            var doctors = storage.getAllDoctors();
            ArrayList<HashMap<String, Object>> doctorList = new ArrayList<>();

            for (Doctor doc : doctors) {
                HashMap<String, Object> data = new HashMap<>();

                data.put("id", doc.getId());
                data.put("fullname", doc.getFirstname() + " " + doc.getLastname());

                doctorList.add(data);
            }

            HashMap<String, Object> result = new HashMap<>();
            result.put("doctors", doctorList);

            return new Response("Doctors found.", Status.OK, result);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Response getDoctorsBySpecialty(Specialty specialty) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
