/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.model.IPatientStorage;
import core.model.IUserStorage;
import core.model.Patient;
import core.model.UserStorage;
import java.time.LocalDate;

/**
 *
 * @author briggoes
 */
public class PatientController {

    //Son el mismo objeto en memoria pero nos referimos a el 
    //a través de dos interfaces que implementa;
    static private IPatientStorage storage = UserStorage.getInstance();

    static Response registerPatient(long id, String username, String fname,
            String lname, String password, String passwordConfirm, String email, LocalDate birthdate,
            boolean gender, long phone, String address) {

        if (fname.trim().equals("") || lname.trim().equals("") || username.trim().equals("")) {
            return new Response("Every field should be filled in.", Status.BAD_REQUEST);
        }

        if (storage.get(id) != null) {
            return new Response("Patient id already exists.", Status.CONFLICT);
        }

        if (id < 0 || id > 999999999999l) {
            return new Response("Patient id should be 12 digits.", Status.BAD_REQUEST);
        }

        if (phone < 1000000000 || phone > 9999999999l) {
            return new Response("Patient phone should be 10 digits.", Status.BAD_REQUEST);
        }
        
        // TODO: validar email y birthdate

        if (storage.get(username) != null) {
            return new Response("Patient username already exists.", Status.CONFLICT);
        }

        if (!passwordConfirm.equals(password)) {
            return new Response("Passwords do not match.", Status.BAD_REQUEST);
        }

        var user = new Patient(id, username, fname, lname, password, email, birthdate, gender, phone, address);
        if (!storage.add(user)) {
            return new Response("Patient id already exists.", Status.CONFLICT);
        }

        return new Response("Registration successful.", Status.OK);
    }

    static Response updatePatientData(long id, String username, String fname,
            String lname, String password, String passwordConfirm, String email, LocalDate birthdate,
            boolean gender, long phone, String address) {

        if (fname.trim().equals("") || lname.trim().equals("") || username.trim().equals("")) {
            return new Response("Every field should be filled in.", Status.BAD_REQUEST);
        }

        if (phone < 1000000000 || phone > 9999999999l) {
            return new Response("Patient phone should be 10 digits.", Status.BAD_REQUEST);
        }

        // TODO: validar email y birthdate
        if (storage.get(username) != null) {
            return new Response("Patient username already exists.", Status.CONFLICT);
        }

        if (!passwordConfirm.equals(password)) {
            return new Response("Passwords do not match.", Status.BAD_REQUEST);
        }

        if (!storage.updatePatient(id, username, fname, lname, password, email, birthdate, gender, phone, address)) {
            return new Response("Patient was not found.", Status.BAD_REQUEST);
        }

        return new Response("Registration successful.", Status.OK);
    }

}
