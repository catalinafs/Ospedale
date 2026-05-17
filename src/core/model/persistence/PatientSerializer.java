/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model.persistence;

import core.model.Patient;
import core.model.User;
import org.json.JSONObject;

/**
 *
 * @author daniel
 */
public class PatientSerializer extends AbstractUserSerializer{
    @Override
    protected boolean canHandle(User user) {
        return user instanceof Patient;
    }
    
    @Override
    protected JSONObject doSerialize(User user) {
        Patient patient = (Patient) user;
        JSONObject json = new JSONObject();
        json.put("type", "patient");
        json.put("id", patient.getId());
        json.put("username", patient.getUsername());
        json.put("firstname", patient.getFirstname());
        json.put("lastname", patient.getLastname());
        json.put("password", patient.getPassword());
        json.put("email", patient.getEmail());
        json.put("birthdate", patient.getBirthdate().toString());
        json.put("gender", patient.isGender());
        json.put("phone", patient.getPhone());
        json.put("address", patient.getAddress());
        return json;
    }
}
