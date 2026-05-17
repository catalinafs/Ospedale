/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.model.UserStorage;

/**
 *
 * @author briggoes
 */
public class PatientController {

    static private UserStorage storage = UserStorage.getInstance();

    static boolean registerPatient(long id, String username, String fname,
            String lname, String password, String email, String birthdate,
            boolean gender, long phone, String address) { // TODO: implement

        if (fname.trim().equals("") || lname.trim().equals("") || username.trim().equals("")) {
            return false;
        }

        return false;
    }

    static boolean updatePatientData(long id, String username, String fname,
            String lname, String password, String email, String birthdate,
            boolean gender, long phone, String address) { // TODO: implement
        return false;
    }

}
