package core.model.persistence;

import core.model.Patient;
import core.model.User;
import java.time.LocalDate;
import org.json.JSONObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author daniel
 */
public class PatientDeserializer extends AbstractUserDeserializer{
    
    @Override
    protected boolean canHandle(String type) {
        return "patient".equals(type);
    }
    
    @Override
    protected User doDeserialize(JSONObject json) {
        return new Patient(
            json.getLong("id"),
            json.getString("username"),
            json.getString("firstname"),
            json.getString("lastname"),
            json.getString("password"),
            json.optString("email", ""),
            LocalDate.parse(json.optString("birthdate", "2000-01-01")),
            json.optBoolean("gender", true),
            json.optLong("phone", 0),
            json.optString("address", "")
        );
    }
}
