/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model.persistence;

import core.model.Doctor;
import core.model.Specialty;
import core.model.User;
import org.json.JSONObject;

/**
 *
 * @author daniel
 */
public class DoctorDeserializer extends AbstractUserDeserializer{
    @Override
    protected boolean canHandle(String type) {
        return "doctor".equals(type);
    }
    
    @Override
    protected User doDeserialize(JSONObject json) {
        Specialty specialty = parseSpecialty(json.optString("specialty", "GENERAL_MEDICINE"));
        return new Doctor(
            json.getLong("id"),
            json.getString("username"),
            json.getString("firstname"),
            json.getString("lastname"),
            json.getString("password"),
            specialty,
            json.optString("licenceNumber", ""),
            json.optString("assignedOffice", "")
        );
    }
    
    private Specialty parseSpecialty(String value) {
        try {
            return Specialty.valueOf(value);
        } catch (Exception e) {
            switch (value) {
                case "ORTHOPEDICS": return Specialty.TRAUMATOLOGY_ORTHOPEDICS;
                case "GYNECOLOGY": return Specialty.GYNECOLOGY_OBSTETRICS;
                default: return Specialty.GENERAL_MEDICINE;
            }
        }
    }
}
