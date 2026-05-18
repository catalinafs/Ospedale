package core.model;


import core.model.Appointment;
import core.model.Doctor;
import core.model.IAppointmentStorage;
import core.model.Specialty;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    private final IDoctorStorage doctorStorage;
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private HashMap<Long, Integer> counters = new HashMap<>();
    
    private AppointmentStorage(IDoctorStorage doctorStorage) {
        this.doctorStorage = doctorStorage;
    }
    
    public static AppointmentStorage getInstance(IDoctorStorage doctorStorage) {
        if (instance == null) {
            instance = new AppointmentStorage(doctorStorage);
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
        LocalTime newTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime newEndTime = newTime.plusMinutes(15);

        for (Appointment a : appointments) {
            if (a.getDoctor().getId() == doctorId) {
                String aDate = a.getDatetime().toLocalDate().toString();
                if (aDate.equals(date)) {
                    LocalTime existingStart = a.getDatetime().toLocalTime();
                    LocalTime existingEnd = existingStart.plusMinutes(15);

                    if (!(newEndTime.isBefore(existingStart) || newTime.isAfter(existingEnd))) {
                        return false;
                    }
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
        for (Doctor doctor : doctorStorage.getAllDoctors()) {
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
