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
public class AdminDeserializer extends AbstractUserDeserializer{
    
    @Override
    protected boolean canHandle(String type) {
        return "admin".equals(type);
    }
    
    @Override
    protected User doDeserialize(JSONObject json) {
        return new Administrator(
            json.getLong("id"),
            json.getString("username"),
            json.getString("firstname"),
            json.getString("lastname"),
            json.getString("password")
        );
    }
}
