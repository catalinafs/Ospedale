/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.model.UserStorage;
import core.model.User;

/**
 *
 * @author briggoes
 */
public class AuthController {

    static private UserStorage storage = UserStorage.getInstance();

    static boolean loginUser(String username, String password) {
        User user = storage.get(username);
        if (user == null) {
            return false;
        }
        if (!user.getPassword().equals(password)) {
            return false;
        }
        return true;
    }
}
