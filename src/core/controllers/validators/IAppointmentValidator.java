/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.controllers.validators;

import core.controllers.utils.Response;
import core.model.Doctor;
import core.model.Specialty;

/**
 *
 * @author daniel
 */
public interface IAppointmentValidator {
    public Response validateDateTime(String date, String time);
    public Response validateDoctor(Doctor doctor);
    public Response validateSpecialty(Specialty specialty);
}
