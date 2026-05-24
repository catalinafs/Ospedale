/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class UserStorage implements IUserStorage {

    private static UserStorage instance = null;
    private static HashMap<Long, User> users;

    private UserStorage() {
        users = new HashMap<>();
    }

    public static UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    @Override
    public User get(Long id) {
        return users.get(id);
    }

    @Override
    public User get(String username) {
        for (User user : users.values()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User get(String fName, String lName) {
        for (User user : users.values()) {
            var fullName = String.format("%s %s", user.getFirstname(), user.getLastname());
            if (fullName.equals(String.format("%s %s", fName, lName))) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean add(User user) {
        users.put(user.getId(), user);
        return true;
    }

    @Override
    public Iterable<User> getStorage() {
        return users.values();
    }
}
