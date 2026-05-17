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
public abstract class AbstractUserSerializer implements UserSerializer{
    protected UserSerializer next;
    
    @Override
    public void setNext(UserSerializer next) {
        this.next = next;
    }
    
    @Override
    public JSONObject serialize(User user) {
        if (canHandle(user)) {
            return doSerialize(user);
        }
        if (next != null) {
            return next.serialize(user);
        }
        return null;
    }
    
    protected abstract boolean canHandle(User user);
    protected abstract JSONObject doSerialize(User user);
}
