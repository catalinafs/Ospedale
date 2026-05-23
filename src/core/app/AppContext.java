package core.app;

import core.controllers.AppointmentController;
import core.controllers.AuthController;
import core.controllers.IAuthController;
import core.controllers.IPatientController;
import core.controllers.PatientController;
import core.controllers.validators.AppointmentValidator;
import core.controllers.validators.PatientValidator;
import core.model.AppointmentStorage;
import core.model.DoctorStorage;
import core.model.HospitalizationStorage;
import core.model.IAppointmentStorage;
import core.model.IDoctorStorage;
import core.model.IHospitalizationStorage;
import core.model.IPatientStorage;
import core.model.IUserStorage;
import core.model.PatientStorage;
import core.model.UserStorage;

public final class AppContext {

    private final IUserStorage userStorage;
    private final IPatientStorage patientStorage;
    private final IDoctorStorage doctorStorage;
    private final IAppointmentStorage appointmentStorage;
    private final IHospitalizationStorage hospitalizationStorage;

    private final IAuthController authController;
    private final IPatientController patientController;
    private final AppointmentController appointmentController;

    public AppContext(
            IUserStorage userStorage,
            IPatientStorage patientStorage,
            IDoctorStorage doctorStorage,
            IAppointmentStorage appointmentStorage,
            IHospitalizationStorage hospitalizationStorage,
            IAuthController authController,
            IPatientController patientController,
            AppointmentController appointmentController) {
        this.userStorage = userStorage;
        this.patientStorage = patientStorage;
        this.doctorStorage = doctorStorage;
        this.appointmentStorage = appointmentStorage;
        this.hospitalizationStorage = hospitalizationStorage;
        this.authController = authController;
        this.patientController = patientController;
        this.appointmentController = appointmentController;
    }

    public static AppContext createDefault() {
        IUserStorage userStorage = UserStorage.getInstance();
        IDoctorStorage doctorStorage = DoctorStorage.getInstance(userStorage);
        IPatientStorage patientStorage = PatientStorage.getInstance(userStorage);
        IAppointmentStorage appointmentStorage = AppointmentStorage.getInstance(doctorStorage);
        IHospitalizationStorage hospitalizationStorage = HospitalizationStorage.getInstance();

        IAuthController authController = new AuthController(userStorage);
        IPatientController patientController = new PatientController(patientStorage, new PatientValidator());
        AppointmentController appointmentController = new AppointmentController(appointmentStorage, patientStorage, doctorStorage, new AppointmentValidator());

        return new AppContext(
                userStorage,
                patientStorage,
                doctorStorage,
                appointmentStorage,
                hospitalizationStorage,
                authController,
                patientController,
                appointmentController);
    }

    public IUserStorage getUserStorage() {
        return userStorage;
    }

    public IPatientStorage getPatientStorage() {
        return patientStorage;
    }

    public IDoctorStorage getDoctorStorage() {
        return doctorStorage;
    }

    public IAppointmentStorage getAppointmentStorage() {
        return appointmentStorage;
    }

    public IHospitalizationStorage getHospitalizationStorage() {
        return hospitalizationStorage;
    }

    public IAuthController getAuthController() {
        return authController;
    }

    public IPatientController getPatientController() {
        return patientController;
    }

    public AppointmentController getAppointmentController() {
        return appointmentController;
    }
}
