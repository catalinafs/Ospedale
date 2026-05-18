package core.model;


import core.model.Appointment;
import core.model.Doctor;
import core.model.IAppointmentStorage;
import core.model.Specialty;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author daniel
 */
public class AppointmentStorage implements IAppointmentStorage{
    private static AppointmentStorage instance = null;
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static HashMap<Long, Integer> counters = new HashMap<>();
    
    private AppointmentStorage() {}
    
    public static AppointmentStorage getInstance() {
        if (instance == null) {
            instance = new AppointmentStorage();
        }
        return instance;
    }
    
    @Override
    public Appointment getAppointment(String id) {
        for (Appointment a : appointments) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }
    
    @Override
    public ArrayList<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments);
    }
    
    @Override
    public boolean isDoctorAvailable(long doctorId, String date, String time) {
        for (Appointment a : appointments) {
            if (a.getDoctor().getId() == doctorId) {
                String aDate = a.getDatetime().toLocalDate().toString();
                String aTime = a.getDatetime().toLocalTime().toString().substring(0, 5);
                if (aDate.equals(date) && aTime.equals(time)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public String generateAppointmentId(long patientId) {
        int counter = counters.getOrDefault(patientId, 0);
        String id = String.format("A-%d-%04d", patientId, counter);
        counters.put(patientId, counter + 1);
        return id;
    }
    
    @Override
    public Doctor findAvailableDoctor(Specialty specialty, String date, String time) {
        for (Doctor doctor : DoctorStorage.getInstance().getAllDoctors()) {
            if (doctor.getSpecialty() == specialty && isDoctorAvailable(doctor.getId(), date, time)) {
                return doctor;
            }
        }
        return null;
    }
    
    @Override
    public boolean addAppointment(Appointment appointment) {
        return appointments.add(appointment);
    }
}
