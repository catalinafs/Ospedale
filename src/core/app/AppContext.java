package core.app;

import core.controllers.AppointmentController;
import core.controllers.AuthController;
import core.controllers.DoctorController;
import core.controllers.HospitalizationController;
import core.controllers.IAppointmentController;
import core.controllers.IAuthController;
import core.controllers.IDoctorController;
import core.controllers.IHospitalizationController;
import core.controllers.IPatientController;
import core.controllers.PatientController;
import core.controllers.validators.AppointmentValidator;
import core.controllers.validators.DoctorValidator;
import core.controllers.validators.HospitalizationValidator;
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
    private final IAppointmentController appointmentController;
    private final IDoctorController doctorController;
    private final IHospitalizationController hospitalizationController;

    public AppContext(
            IUserStorage userStorage,
            IPatientStorage patientStorage,
            IDoctorStorage doctorStorage,
            IAppointmentStorage appointmentStorage,
            IHospitalizationStorage hospitalizationStorage,
            IAuthController authController,
            IPatientController patientController,
            IAppointmentController appointmentController,
            IDoctorController doctorController,
            IHospitalizationController hospitalizationController) {
        this.userStorage = userStorage;
        this.patientStorage = patientStorage;
        this.doctorStorage = doctorStorage;
        this.appointmentStorage = appointmentStorage;
        this.hospitalizationStorage = hospitalizationStorage;
        this.authController = authController;
        this.patientController = patientController;
        this.appointmentController = appointmentController;
        this.doctorController = doctorController;
        this.hospitalizationController = hospitalizationController;
    }

    public static AppContext createDefault() {
        IUserStorage userStorage = UserStorage.getInstance();
        IDoctorStorage doctorStorage = DoctorStorage.getInstance(userStorage);
        IPatientStorage patientStorage = PatientStorage.getInstance(userStorage);
        IAppointmentStorage appointmentStorage = AppointmentStorage.getInstance(doctorStorage);
        IHospitalizationStorage hospitalizationStorage = HospitalizationStorage.getInstance();

        IAuthController authController = new AuthController(userStorage);
        IPatientController patientController = new PatientController(patientStorage, new PatientValidator());
        IAppointmentController appointmentController = new AppointmentController(appointmentStorage, patientStorage, doctorStorage, new AppointmentValidator());
        IDoctorController doctorController = new DoctorController(doctorStorage, new DoctorValidator());
        IHospitalizationController hospitalizationController = new HospitalizationController(hospitalizationStorage, patientStorage, doctorStorage, new HospitalizationValidator());
        
        return new AppContext(
                userStorage,
                patientStorage,
                doctorStorage,
                appointmentStorage,
                hospitalizationStorage,
                authController,
                patientController,
                appointmentController,
                doctorController,
                hospitalizationController);
    }

    public IHospitalizationController getHospitalizationController() {
        return hospitalizationController;
    }

    public IUserStorage getUserStorage() {
        return userStorage;
    }

    public IDoctorController getDoctorController() {
        return doctorController;
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

    public IAppointmentController getAppointmentController() {
        return appointmentController;
    }
}
