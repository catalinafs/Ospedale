/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public interface IPatientStorage{
    public Patient getPatient(long id);
    public Patient getPatientByUsername(String username);
    public boolean addPatient(Patient patient);
    public boolean updatePatient(
            long id, 
            String username, 
            String firstname, 
            String lastname, 
            String password, 
            String email, 
            LocalDate birthdate, 
            boolean gender, 
            long phone, 
            String address
    );
    public ArrayList<Patient> getAllPatients();
}
