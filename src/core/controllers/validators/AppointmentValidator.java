/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.validators;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.model.Doctor;
import core.model.Specialty;

/**
 *
 * @author daniel
 */
public class AppointmentValidator implements IAppointmentValidator{
    private static final int[] VALID_MINUTES = {0, 15, 30, 45};
    
    @Override
    public Response validateDateTime(String date, String time) {
        Response dateError = validateDate(date);
        if (dateError != null) return dateError;
        
        Response timeError = validateTime(time);
        if (timeError != null) return timeError;
        
        return null;
    }
    
    private Response validateDate(String date) {
        if (date == null || date.length() != 10) {
            return new Response("Date is required (format: YYYY-MM-DD).", Status.BAD_REQUEST);
        }
        
        if (date.charAt(4) != '-' || date.charAt(7) != '-') {
            return new Response("Date must be valid (format: YYYY-MM-DD).", Status.BAD_REQUEST);
        }
        
        for (int i = 0; i < date.length(); i++) {
            if (i == 4 || i == 7) continue;
            if (!Character.isDigit(date.charAt(i))) {
                return new Response("Date must be valid (format: YYYY-MM-DD).", Status.BAD_REQUEST);
            }
        }
        
        try {
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8, 10));
            
            if (month < 1 || month > 12 || day < 1 || day > 31) {
                return new Response("Date must be valid (format: YYYY-MM-DD).", Status.BAD_REQUEST);
            }
        } catch (NumberFormatException e) {
            return new Response("Date must be valid (format: YYYY-MM-DD).", Status.BAD_REQUEST);
        }
        
        return null;
    }
    
    private Response validateTime(String time) {
        if (time == null || time.length() != 5) {
            return new Response("Time is required (format: hh:mm).", Status.BAD_REQUEST);
        }
        
        if (time.charAt(2) != ':') {
            return new Response("Time must follow format hh:mm.", Status.BAD_REQUEST);
        }
        
        try {
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));
            
            if (hour < 0 || hour > 23) {
                return new Response("Hour must be between 00 and 23.", Status.BAD_REQUEST);
            }
            
            boolean validMinute = false;
            for (int m : VALID_MINUTES) {
                if (minute == m) { validMinute = true; break; }
            }
            if (!validMinute) {
                return new Response("Minutes must be in {00, 15, 30, 45}.", Status.BAD_REQUEST);
            }
        } catch (NumberFormatException e) {
            return new Response("Time must be valid (format: hh:mm).", Status.BAD_REQUEST);
        }
        
        return null;
    }
    
    @Override
    public Response validateDoctor(Doctor doctor) {
        if (doctor == null) {
            return new Response("Doctor is required.", Status.BAD_REQUEST);
        }
        return null;
    }
    
    @Override
    public Response validateSpecialty(Specialty specialty) {
        if (specialty == null) {
            return new Response("Specialty is required.", Status.BAD_REQUEST);
        }
        return null;
    }
}
