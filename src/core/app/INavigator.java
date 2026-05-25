/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.app;

import core.controllers.utils.Response;
import core.model.User;

/**
 *
 * @author briggoes
 */
public interface INavigator {
    public AppContext getAppContext();
    
    public void showMain();
    public void showAdmin(User user);
    public void showDoctor(User user);
    public void showPatient(User user);
    
    public void logout();
    public void openAfterLogin(Object type, Object id);
}
