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
public class DoctorStorage implements IDoctorStorage{
    private static DoctorStorage instance = null;
    private static IUserStorage userStorage = UserStorage.getInstance();
    
    private DoctorStorage() {}
    
    public static DoctorStorage getInstance() {
        if (instance == null) {
            instance = new DoctorStorage();
        }
        return instance;
    }
    
    @Override
    public Doctor getDoctor(long id) {
        User user = userStorage.get(id);
        if (user instanceof Doctor) {
            return (Doctor) user;
        }
        return null;
    }
    
    @Override
    public Doctor getDoctorByUsername(String username) {
        User user = userStorage.get(username);
        if (user instanceof Doctor) {
            return (Doctor) user;
        }
        return null;
    }
    
    @Override
    public boolean addDoctor(Doctor doctor) {
        return userStorage.add(doctor);
    }
    
    @Override
    public boolean updateDoctor(long id, String username, String firstname, 
            String lastname, String password, String licenceNumber, String assignedOffice) {
        Doctor doctor = getDoctor(id);
        if (doctor != null) {
            doctor.setUsername(username);
            doctor.setFirstname(firstname);
            doctor.setLastname(lastname);
            doctor.setPassword(password);
            doctor.setLicenceNumber(licenceNumber);
            doctor.setAssignedOffice(assignedOffice);
            return true;
        }
        return false;
    }
    
    @Override
    public ArrayList<Doctor> getAllDoctors() {
        ArrayList<Doctor> list = new ArrayList<>();
        for (User user : userStorage.getStorage()) {
            if (user instanceof Doctor) {
                list.add((Doctor) user);
            }
        }
        return list;
    }
    
    @Override
    public ArrayList<Doctor> getDoctorsBySpecialty(Specialty specialty) {
        ArrayList<Doctor> list = new ArrayList<>();
        for (Doctor doctor : getAllDoctors()) {
            if (doctor.getSpecialty() == specialty) {
                list.add(doctor);
            }
        }
        return list;
    }
}
