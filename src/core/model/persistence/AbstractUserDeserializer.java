/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model.persistence;

import core.model.User;
import org.json.JSONObject;

/**
 *
 * @author daniel
 */
public abstract class AbstractUserDeserializer implements UserDeserializer{
     protected UserDeserializer next;
    
    @Override
    public void setNext(UserDeserializer next) {
        this.next = next;
    }
    
    @Override
    public User deserialize(JSONObject json) {
        String type = json.optString("type", "");
        if (canHandle(type)) {
            return doDeserialize(json);
        }
        if (next != null) {
            return next.deserialize(json);
        }
        return null;
    }
    
    protected abstract boolean canHandle(String type);
    protected abstract User doDeserialize(JSONObject json);
}
