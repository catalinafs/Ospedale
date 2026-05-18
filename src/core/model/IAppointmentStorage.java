/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.model;

import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public interface IAppointmentStorage {
    public Appointment getAppointment(String id);
    public ArrayList<Appointment> getAllAppointments();
    public boolean isDoctorAvailable(long doctorId, String date, String time);
    public String generateAppointmentId(long patientId);
    public Doctor findAvailableDoctor(Specialty specialty, String date, String time);
    public boolean addAppointment(Appointment appointment);
}
