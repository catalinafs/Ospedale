/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model;

import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class Storage {

    private static Storage instance = null;
    private static HashMap<Long, Object> storage;

    private Storage() {
        storage = new HashMap<Long, Object>();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
            return instance;
        }
        return instance;
    }

    public User getUser(Long id) {
        return (User) storage.get(id);
    }
    
    public User getUser(String username) {
        for (Object value : storage.values()) {
            if (value instanceof User) {
                User user = (User) value;
                if (user.getUsername().equals(username)) {
                    return user;
                }
            }
        }
        return null;
    }
}
