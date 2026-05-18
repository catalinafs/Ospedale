/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Status;
import core.controllers.utils.Response;
import core.controllers.validators.IUserValidator;
import core.model.Administrator;
import core.model.Doctor;
import core.model.IUserStorage;
import core.model.Patient;
import core.model.User;
import java.util.HashMap;

/**
 *
 * @author briggoes
 */
public class AuthController implements IAuthController{
    private final IUserStorage storage;
    private final IUserValidator validator;
    
    public AuthController(IUserStorage storage, IUserValidator validator) {
        this.storage = storage;
        this.validator = validator;
    }
    
    @Override
    public Response login(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            return new Response("Username is required.", Status.BAD_REQUEST);
        }
        if (password == null || password.trim().isEmpty()) {
            return new Response("Password is required.", Status.BAD_REQUEST);
        }

        User user = storage.get(username);
        if (user == null) {
            return new Response("Wrong username or password.", Status.UNAUTHORIZED);
        }
        if (!user.getPassword().equals(password)) {
            return new Response("Wrong username or password.", Status.UNAUTHORIZED);
        }

        // Serialize user data
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", user.getId());
        data.put("username", user.getUsername());
        data.put("firstname", user.getFirstname());
        data.put("lastname", user.getLastname());

        // Add type-specific data
        if (user instanceof Administrator) {
            data.put("type", "admin");
        } else if (user instanceof Doctor) {
            data.put("type", "doctor");
            data.put("specialty", ((Doctor)user).getSpecialty().toString());
        } else if (user instanceof Patient) {
            data.put("type", "patient");
            data.put("gender", ((Patient)user).isGender());
            data.put("email", ((Patient)user).getEmail());
            data.put("birthdate", ((Patient)user).getBirthdate().toString());
            data.put("phone", ((Patient)user).getPhone());
            data.put("address", ((Patient)user).getAddress());
        }

        return new Response("Login successful.", Status.OK, data);
    }
    
    @Override
    public Response logout() {
        return new Response("Logout successful.", Status.OK);
    }
}
