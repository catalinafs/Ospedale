/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model.persistence;

import core.model.Administrator;
import core.model.User;
import org.json.JSONObject;

/**
 *
 * @author daniel
 */
public class AdminSerializer extends AbstractUserSerializer{
    @Override
    protected boolean canHandle(User user) {
        return user instanceof Administrator;
    }
    
    @Override
    protected JSONObject doSerialize(User user) {
        Administrator admin = (Administrator) user;
        JSONObject json = new JSONObject();
        json.put("type", "admin");
        json.put("id", admin.getId());
        json.put("username", admin.getUsername());
        json.put("firstname", admin.getFirstname());
        json.put("lastname", admin.getLastname());
        json.put("password", admin.getPassword());
        return json;
    }
}
