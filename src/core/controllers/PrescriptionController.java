package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.controllers.validators.IPrescriptionValidator;
import core.model.Appointment;
import core.model.AppointmentStatus;
import core.model.Doctor;
import core.model.IAppointmentStorage;
import core.model.IDoctorStorage;
import core.model.Prescription;
import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class PrescriptionController implements IPrescription{
    private final IAppointmentStorage appointmentStorage;
    private final IDoctorStorage doctorStorage;
    private final IPrescriptionValidator validator;
    
    public PrescriptionController(IAppointmentStorage appointmentStorage, IDoctorStorage doctorStorage, IPrescriptionValidator validator) {
        this.appointmentStorage = appointmentStorage;
        this.doctorStorage = doctorStorage;
        this.validator = validator;
    }
    
     @Override
    public Response prescribeMedication(String appointmentId, long doctorId, String medication, String doseStr, String administrationRoute, String treatmentDurationStr, String additionalInstructions, String frequencyStr) {
        try {
            Appointment appointment = appointmentStorage.getAppointment(appointmentId);
            if (appointment == null) {
                return new Response("Appointment not found.", Status.NOT_FOUND);
            }
            Doctor doctor = doctorStorage.getDoctor(doctorId);
            if (doctor == null) {
                return new Response("Doctor not found.", Status.NOT_FOUND);
            }
            if (appointment.getDoctor().getId() != doctorId) {
                return new Response("You are not the doctor of this appointment.", Status.UNAUTHORIZED);
            }
            if (appointment.getStatus() != AppointmentStatus.PENDING) {
                return new Response("Cannot prescribe medication: appointment must be in PENDING state.", Status.BAD_REQUEST);
            }
            
            Response validationError = validator.validate(medication, doseStr, administrationRoute, treatmentDurationStr, additionalInstructions, frequencyStr);
            if (validationError != null) {
                return validationError;
            }
            
            double dose = Double.parseDouble(doseStr);
            int treatmentDuration = Integer.parseInt(treatmentDurationStr);
            int frequency = Integer.parseInt(frequencyStr);
            
            Prescription prescription = new Prescription(appointment, medication, dose, administrationRoute,
                             treatmentDuration, additionalInstructions, frequency);
            appointment.addPrescription(prescription);
            
            HashMap<String, Object> data = new HashMap<>();
            data.put("appointmentId", appointmentId);
            data.put("medicationName", medication);
            data.put("dose", dose);
            data.put("administrationRoute", administrationRoute);
            data.put("treatmentDuration", treatmentDuration);
            data.put("additionalInstructions", additionalInstructions);
            data.put("frequency", frequency);
            return new Response("Medication prescribed successfully.", Status.CREATED, data);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
