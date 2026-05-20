/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.controllers.validators;

import core.controllers.utils.Response;

/**
 *
 * @author daniel
 */
public interface IUserValidator {
    public Response validateUsername(String username);
    public Response validatePassword(String password, String passwordConfirm);
    public Response validateId(String id);
}
