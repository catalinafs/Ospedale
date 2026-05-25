package core.app;

import core.controllers.AppointmentController;
import core.controllers.AuthController;
import core.controllers.DoctorController;
import core.controllers.HospitalizationController;
import core.controllers.PatientController;
import core.controllers.utils.Response;
import core.model.Administrator;
import core.model.Doctor;
import core.model.Patient;
import core.model.User;
import core.view.AdminView;
import core.view.DoctorView;
import core.view.MainView;
import core.view.PatientView;
import javax.swing.JFrame;

public final class Navigator implements INavigator {

    private final AppContext appContext;
    private JFrame currentFrame;

    public Navigator(AppContext appContext) {
        this.appContext = appContext;
    }

    public AppContext getAppContext() {
        return appContext;
    }

    public void showMain() {
        hideCurrent();
        MainView mainView = new MainView(
                appContext.getPatientController(),
                appContext.getAuthController(),
                this
        );
        currentFrame = mainView;
        mainView.setVisible(true);
    }

    public void openAfterLogin(Object typeObj, Object idObj) {
        if (!(typeObj instanceof String type) || !(idObj instanceof Number idNumber)) {
            return;
        }

        User user = appContext.getUserStorage().get(idNumber.longValue());
        if (user == null) {
            return;
        }

        hideCurrent();

        switch (type) {
            case "admin" ->
                showAdmin(user);
            case "doctor" ->
                showDoctor(user);
            case "patient" ->
                showPatient(user);
            default ->
                showMain();
        }
    }

    public void showAdmin(User user) {
        if (!(user instanceof Administrator admin)) {
            throw new IllegalArgumentException("User is not an administrator.");
        }
        
        hideCurrent();
        AdminView adminView = new AdminView(
                user.getId(),
                appContext.getPatientController(),
                appContext.getDoctorController(),
                this
        );
        currentFrame = adminView;
        adminView.setVisible(true);
    }

    public void showDoctor(User user) {
        if (!(user instanceof Doctor doctor)) {
            throw new IllegalArgumentException("User is not a patient.");
        }

        hideCurrent();
        DoctorView doctorView = new DoctorView(
                user.getId(),
                appContext.getAuthController(),
                appContext.getPatientController(),
                appContext.getDoctorController(),
                appContext.getAppointmentController(),
                appContext.getHospitalizationController(),
                this
        );
        currentFrame = doctorView;
        doctorView.setVisible(true);
    }

    public void showPatient(User user) {
        if (!(user instanceof Patient patient)) {
            throw new IllegalArgumentException("User is not a patient.");
        }

        hideCurrent();
        PatientView patientView = new PatientView(
                user.getId(),
                appContext.getAuthController(),
                appContext.getPatientController(),
                appContext.getDoctorController(),
                appContext.getAppointmentController(),
                appContext.getHospitalizationController(),
                this
        );
        currentFrame = patientView;
        patientView.setVisible(true);
    }

    public void logout() {
        appContext.getAuthController().logout();
        showMain();
    }

    private void hideCurrent() {
        if (currentFrame != null) {
            currentFrame.setVisible(false);
        }
    }
}
