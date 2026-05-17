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
public class UserStorage implements IUserStorage{

    private static UserStorage instance = null;
    private static HashMap<Long, User> storage;
    
    private UserStorage() {
        storage = new HashMap<Long, User>();
    }
    
    public static UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
            return instance;
        }
        return instance;
    }
    
    @Override
    public User get(Long id) {
        return storage.get(id);
    }
    
    @Override
    public User get(String username) {
        for (User user : storage.values()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    @Override
    public void add(User user) {
        storage.put(user.getId(), user);
    }

    @Override
    public Iterable<User> getStorage() {
        return storage.values();
    }
}