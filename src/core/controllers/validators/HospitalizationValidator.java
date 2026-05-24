/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers.validators;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.model.RoomType;

/**
 *
 * @author briggoes
 */
public class HospitalizationValidator implements IHospitalizationValidator {

    @Override
    public Response validateAdmissionDate(String date) {
        Response invalidFormat = new Response("Date is required (format: YYYY-MM-DD).", Status.BAD_REQUEST);

        if (date == null || date.length() != 10) {
            return invalidFormat;
        }

        if (date.charAt(4) != '-' || date.charAt(7) != '-') {
            return invalidFormat;

        }

        for (int i = 0; i < date.length(); i++) {
            if (i == 4 || i == 7) {
                continue;
            }
            if (!Character.isDigit(date.charAt(i))) {
                return invalidFormat;
            }
        }

        try {
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8, 10));

            if (month < 1 || month > 12 || day < 1 || day > 31) {
                return invalidFormat;
            }
        } catch (NumberFormatException e) {
            return invalidFormat;
        }

        return null;
    }

}
