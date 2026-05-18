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
public class PatientStorage implements IPatientStorage{
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
            boolean gender, long phone, String address) {
        Patient patient = getPatient(id);
        if (patient != null) {
            patient.setUsername(username);
            patient.setFirstname(firstname);
            patient.setLastname(lastname);
            patient.setPassword(password);
            patient.setEmail(email);
            patient.setBirthdate(birthdate);
            patient.setGender(gender);
            patient.setPhone(phone);
            patient.setAddress(address);
            return true;
        }
        return false;
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
}
