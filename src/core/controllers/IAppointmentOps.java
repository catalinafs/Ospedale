package core.controllers;

import core.controllers.utils.Response;

public interface IAppointmentOps {

    public Response requestAppointment(
            long patientId,
            String date,
            String time,
            int type,
            String reason,
            String doctorOrSpecialty,
            boolean isSpecialty
    );

    public Response acceptAppointment(String appointmentId, long doctorId);

    public Response completeAppointment(String appointmentId, long doctorId, String diagnosis, String followUp, String recommendedTreatment, String observations);

    public Response cancelAppointment(String appointmentId, long patientId);

    public Response rescheduleAppointment(
            String appointmentId,
            long doctorId,
            String newTime,
            String reason
    );
}
