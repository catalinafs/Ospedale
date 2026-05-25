package core.app;

import core.controllers.AppointmentController;
import core.controllers.AuthController;
import core.controllers.DoctorController;
import core.controllers.HospitalizationController;
import core.controllers.IAuthController;
import core.controllers.IDoctorController;
import core.controllers.IHospitalizationOps;
import core.controllers.IPatientController;
import core.controllers.IPrescription;
import core.controllers.PatientController;
import core.controllers.PrescriptionController;
import core.controllers.validators.AppointmentValidator;
import core.controllers.validators.DoctorValidator;
import core.controllers.validators.HospitalizationValidator;
import core.controllers.validators.PatientValidator;
import core.controllers.validators.PrescriptionValidator;
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
import core.model.persistence.AdminDeserializer;
import core.model.persistence.AdminSerializer;
import core.model.persistence.DoctorDeserializer;
import core.model.persistence.DoctorSerializer;
import core.model.persistence.FileHandler;
import core.model.persistence.IUserPersistence;
import core.model.persistence.PatientDeserializer;
import core.model.persistence.PatientSerializer;
import core.model.persistence.UserDeserializer;
import core.model.persistence.UserPersistence;
import core.model.persistence.UserSerializer;

public final class AppContext {

    private final IUserStorage userStorage;
    private final IPatientStorage patientStorage;
    private final IDoctorStorage doctorStorage;
    private final IAppointmentStorage appointmentStorage;
    private final IHospitalizationStorage hospitalizationStorage;
    private final IUserPersistence persistence;

    private final IAuthController authController;
    private final IPatientController patientController;
    private final AppointmentController appointmentController;
    private final IDoctorController doctorController;
    private final IHospitalizationOps hospitalizationController;
    private final IPrescription prescriptionController;

    public AppContext(
            IUserStorage userStorage,
            IPatientStorage patientStorage,
            IDoctorStorage doctorStorage,
            IAppointmentStorage appointmentStorage,
            IHospitalizationStorage hospitalizationStorage,
            IUserPersistence persistence,
            IAuthController authController,
            IPatientController patientController,
            AppointmentController appointmentController,
            IDoctorController doctorController,
            IHospitalizationOps hospitalizationController,
            IPrescription prescriptionController) {
        this.userStorage = userStorage;
        this.patientStorage = patientStorage;
        this.doctorStorage = doctorStorage;
        this.appointmentStorage = appointmentStorage;
        this.hospitalizationStorage = hospitalizationStorage;
        this.persistence = persistence;
        this.authController = authController;
        this.patientController = patientController;
        this.appointmentController = appointmentController;
        this.doctorController = doctorController;
        this.hospitalizationController = hospitalizationController;
        this.prescriptionController = prescriptionController;
    }

    public static AppContext createDefault() {
        IUserStorage userStorage = UserStorage.getInstance();
        IDoctorStorage doctorStorage = DoctorStorage.getInstance(userStorage);
        IPatientStorage patientStorage = PatientStorage.getInstance(userStorage);
        IAppointmentStorage appointmentStorage = AppointmentStorage.getInstance(doctorStorage);
        IHospitalizationStorage hospitalizationStorage = HospitalizationStorage.getInstance();
        
        UserSerializer adminSer = new AdminSerializer();
        UserSerializer doctorSer = new DoctorSerializer();
        UserSerializer patientSer = new PatientSerializer();
        adminSer.setNext(doctorSer);
        doctorSer.setNext(patientSer);
        
        UserDeserializer adminDes = new AdminDeserializer();
        UserDeserializer doctorDes = new DoctorDeserializer();
        UserDeserializer patientDes = new PatientDeserializer();
        adminDes.setNext(doctorDes);
        doctorDes.setNext(patientDes);
        
        IUserPersistence persistence = new UserPersistence(new FileHandler(), adminSer, adminDes, "json/users.json");
        persistence.load(userStorage);
        
        IAuthController authController = new AuthController(userStorage);
        IPatientController patientController = new PatientController(patientStorage, new PatientValidator());
        AppointmentController appointmentController = new AppointmentController(appointmentStorage, patientStorage, doctorStorage, new AppointmentValidator());
        IDoctorController doctorController = new DoctorController(doctorStorage, new DoctorValidator(), persistence);
        IHospitalizationOps hospitalizationController = new HospitalizationController(hospitalizationStorage, patientStorage, doctorStorage, new HospitalizationValidator());
        IPrescription prescriptionController = new PrescriptionController(appointmentStorage, doctorStorage, new PrescriptionValidator());
        
        return new AppContext(
                userStorage,
                patientStorage,
                doctorStorage,
                appointmentStorage,
                hospitalizationStorage,
                persistence,
                authController,
                patientController,
                appointmentController,
                doctorController,
                hospitalizationController,
                prescriptionController);
    }

    public IHospitalizationOps getHospitalizationController() {
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

    public AppointmentController getAppointmentController() {
        return appointmentController;
    }

    public IPrescription getPrescriptionController() {
        return prescriptionController;
    }
    
    public IUserPersistence getPersistence() {
        return persistence;
    }
}
