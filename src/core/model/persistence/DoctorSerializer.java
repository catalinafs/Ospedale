/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model.persistence;

import core.model.Doctor;
import core.model.User;
import org.json.JSONObject;

/**
 *
 * @author daniel
 */
public class DoctorSerializer extends AbstractUserSerializer{
    @Override
    protected boolean canHandle(User user) {
        return user instanceof Doctor;
    }
    
    @Override
    protected JSONObject doSerialize(User user) {
        Doctor doctor = (Doctor) user;
        JSONObject json = new JSONObject();
        json.put("type", "doctor");
        json.put("id", doctor.getId());
        json.put("username", doctor.getUsername());
        json.put("firstname", doctor.getFirstname());
        json.put("lastname", doctor.getLastname());
        json.put("password", doctor.getPassword());
        json.put("specialty", doctor.getSpecialty().name());
        json.put("licenceNumber", doctor.getLicenceNumber());
        json.put("assignedOffice", doctor.getAssignedOffice());
        return json;
    }
}
