/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class PatientStorage implements IPatientStorage {

    private static PatientStorage instance = null;
    private final IUserStorage userStorage;

    private PatientStorage(IUserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public static PatientStorage getInstance(IUserStorage userStorage) {
        if (instance == null) {
            instance = new PatientStorage(userStorage);
        }
        return instance;
    }

    @Override
    public Patient getPatient(long id) {
        User user = userStorage.get(id);
        if (user instanceof Patient) {
            return (Patient) user;
        }
        return null;
    }

    @Override
    public Patient getPatientByUsername(String username) {
        User user = userStorage.get(username);
        if (user instanceof Patient) {
            return (Patient) user;
        }
        return null;
    }

    @Override
    public boolean addPatient(Patient patient) {
        return userStorage.add(patient);
    }

    @Override
    public boolean updatePatient(long id, String username, String firstname,
            String lastname, String password, String email, LocalDate birthdate,
            Boolean gender, Long phone, String address) {
        Patient patient = getPatient(id);
        if (patient == null) {
            return false;
        }
        if (hasText(username)) {
            patient.setUsername(username.trim());
        }
        if (hasText(firstname)) {
            patient.setFirstname(firstname.trim());
        }
        if (hasText(lastname)) {
            patient.setLastname(lastname.trim());
        }
        if (hasText(password)) {
            patient.setPassword(password);
        }
        if (hasText(email)) {
            patient.setEmail(email.trim());
        }
        if (birthdate != null) {
            patient.setBirthdate(birthdate);
        }
        if (gender != null) {
            patient.setGender(gender);
        }
        if (phone != null) {
            patient.setPhone(phone);
        }
        if (hasText(address)) {
            patient.setAddress(address.trim());
        }
        return true;
    }

    private static boolean hasText(String value) {
        return value != null && !value.trim().isEmpty();
    }

    @Override
    public ArrayList<Patient> getAllPatients() {
        ArrayList<Patient> list = new ArrayList<>();
        for (User user : userStorage.getStorage()) {
            if (user instanceof Patient) {
                list.add((Patient) user);
            }
        }
        return list;
    }

    @Override
    public Patient getPatientByFullName(String fullname) {
        var names = fullname.split(" ");
        User user = userStorage.get(names[0], names[1]);
        if (user instanceof Patient pat) {
            return pat;
        }
        return null;
    }
}
