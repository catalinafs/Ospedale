/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.model;

import java.time.LocalDate;

/**
 *
 * @author daniel
 */
public interface IPatientStorage extends IUserStorage{
    public boolean updatePatient(long id, String username, String firstname, 
    String lastname, String password, String email, LocalDate birthdate, 
    boolean gender, long phone, String address);
}
