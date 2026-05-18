/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model;

import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class UserStorage implements IUserStorage, IPatientStorage{

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
    public boolean add(User user) {
        storage.put(user.getId(), user);
        return true;
    }

    @Override
    public Iterable<User> getStorage() {
        return storage.values();
    }
    
    @Override
    public boolean updatePatient(long id, String username, String firstname, 
        String lastname, String password, String email, LocalDate birthdate, 
        boolean gender, long phone, String address) {
        User user = storage.get(id);
        if (user instanceof Patient) {
            Patient p = (Patient) user;
            p.setUsername(username);
            p.setFirstname(firstname);
            p.setLastname(lastname);
            p.setPassword(password);
            p.setEmail(email);
            p.setBirthdate(birthdate);
            p.setGender(gender);
            p.setPhone(phone);
            p.setAddress(address);
            return true;
        }
        return false;
    }
}