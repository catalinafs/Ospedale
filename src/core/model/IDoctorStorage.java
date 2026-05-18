/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model;

import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public interface IDoctorStorage{
    public Doctor getDoctor(long id);
    public Doctor getDoctorByUsername(String username);
    public boolean addDoctor(Doctor doctor);
    public boolean updateDoctor(
            long id, 
            String username, 
            String firstname, 
            String lastname, 
            String password, 
            String licenceNumber, 
            String assignedOffice
    );
    public ArrayList<Doctor> getAllDoctors();
    public ArrayList<Doctor> getDoctorsBySpecialty(Specialty specialty);
}
