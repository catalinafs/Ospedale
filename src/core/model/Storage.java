/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class Storage {
    
    private static Storage instance = null;
    private static ArrayList<User> users;
    
    private Storage() {
        users = new ArrayList<User>();
    }
    
    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
            return instance;
        }
        return instance;
    }
    
    public User getUserById(long id) {
        for (var user : users) {
            if (user.id == id) {
                return user;
            }
        }
        return null;
    }
    
    public boolean addUser(User user) {
        if (getUserById(user.id) != null) {
            return false;
        }
        users.add(user);
        return true;
    }
    
    public User getUserByUsername(String username) {
        for (var user : users) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }
    
    public boolean updatePatient(long id, String username, String fname, String lname, String password, String email, LocalDate birthdate, boolean gender, long phone, String address) {
        User found = getUserById(id);
        if (!(found instanceof Patient patient)) {
            return false;
        }
        
        patient.setUsername(username);
        patient.setFirstname(fname);
        patient.setLastname(lname);
        patient.setPassword(fname);
        patient.setEmail(email);
        patient.setBirthdate(birthdate);
        patient.setGender(gender);
        patient.setPhone(phone);
        patient.setAddress(address);
        
        return true;
    }
}
