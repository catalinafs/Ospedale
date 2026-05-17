/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Status;
import core.controllers.utils.Response;
import core.model.Storage;
import core.model.User;

/**
 *
 * @author briggoes
 */
public class AuthController {

    static private Storage storage = Storage.getInstance();

    static Response loginUser(String username, String password) {
        User user = storage.getUserByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            return new Response("Wrong username or password.", Status.UNAUTHORIZED);
        }
        return new Response("Login successful.", Status.OK);
    }
}
