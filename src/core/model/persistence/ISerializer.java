/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.model.persistence;

import core.model.User;
import org.json.JSONObject;

/**
 *
 * @author daniel
 */
public interface ISerializer {
    public JSONObject serialize(User user);    
}
