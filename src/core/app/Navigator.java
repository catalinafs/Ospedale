package core.app;

import core.controllers.AppointmentController;
import core.controllers.AuthController;
import core.controllers.PatientController;
import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.model.Administrator;
import core.model.Appointment;
import core.model.Doctor;
import core.model.Hospitalization;
import core.model.Patient;
import core.model.User;
import core.view.AdminView;
import core.view.DoctorView;
import core.view.MainView;
import core.view.PatientView;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JFrame;

public final class Navigator {

    private final AppContext appContext;
    private JFrame currentFrame;
    private User currentUser;

    public Navigator(AppContext appContext) {
        this.appContext = appContext;
    }

    public AppContext getAppContext() {
        return appContext;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void showMain() {
        currentUser = null;
        hideCurrent();
        MainView mainView = new MainView(
                (PatientController) appContext.getPatientController(),
                (AuthController) appContext.getAuthController(),
                this
        );
        currentFrame = mainView;
        mainView.setVisible(true);
    }

    public void openAfterLogin(Response loginResponse) {
        Map<String, Object> data = loginResponse.getData();

        Object typeObj = data.get("type");
        Object idObj = data.get("id");
        if (!(typeObj instanceof String type) || !(idObj instanceof Number idNumber)) {
            return;
        }

        User user = appContext.getUserStorage().get(idNumber.longValue());
        if (user == null) {
            return;
        }

        currentUser = user;
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
        throw new UnsupportedOperationException("Not implemented");
    }

    public void showDoctor(User user) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void showPatient(User user) {
        if (!(user instanceof Patient patient)) {
            throw new IllegalArgumentException("User is not a patient.");
        }

        hideCurrent();
        PatientView patientView = new PatientView(
                user,
                patient,
                (PatientController) appContext.getPatientController(),
                (AppointmentController) appContext.getAppointmentController(),
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
