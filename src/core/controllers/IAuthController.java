/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;

/**
 *
 * @author daniel
 */
public interface IAuthController {
    public Response login(String username, String password);
    public Response userIsOfType(String type, long userId);
    public Response logout();
}
