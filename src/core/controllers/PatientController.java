package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.controllers.validators.IPatientValidator;
import core.model.IPatientStorage;
import core.model.Patient;
import core.model.UserStorage;
import core.model.persistence.IUserPersistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class PatientController implements IPatientController {

    private final IPatientStorage storage;
    private final IPatientValidator validator;
    private final IUserPersistence persistence;

    public PatientController(IPatientStorage storage, IPatientValidator validator, IUserPersistence persistence) {
        this.storage = storage;
        this.validator = validator;
        this.persistence = persistence;
    }

    @Override
    public Response register(String id_str, String username, String firstname,
            String lastname, String password, String passwordConfirm, String email,
            String birth, int gender_ind, String phone_str, String address) {
        try {
            if (firstname == null || firstname.trim().isEmpty()) {
                return new Response("Firstname is required.", Status.BAD_REQUEST);
            }
            if (lastname == null || lastname.trim().isEmpty()) {
                return new Response("Lastname is required.", Status.BAD_REQUEST);
            }
            Response error = validator.validateId(id_str);
            if (error != null) {
                return error;
            }
            long id = Long.parseLong(id_str);
            if (storage.getPatient(id) != null) {
                return new Response("Patient id already exists.", Status.CONFLICT);
            }
            error = validator.validateGender(gender_ind);
            if (error != null) {
                return error;
            }
            error = validator.validateBirthdate(birth);
            if (error != null) {
                return error;
            }
            if (address == null || address.trim().isEmpty()) {
                return new Response("Address is required.", Status.BAD_REQUEST);
            }
            error = validator.validatePhone(phone_str);
            if (error != null) {
                return error;
            }
            error = validator.validateEmail(email);
            if (error != null) {
                return error;
            }
            error = validator.validateUsername(username);
            if (error != null) {
                return error;
            }
            if (storage.getPatientByUsername(username) != null) {
                return new Response("Patient username already exists.", Status.CONFLICT);
            }
            error = validator.validatePassword(password, passwordConfirm);
            if (error != null) {
                return error;
            }

            boolean gender = (gender_ind == 1);
            long phone = Long.parseLong(phone_str);
            LocalDate birthdate = LocalDate.of(Integer.parseInt(birth.substring(0, 4)), Integer.parseInt(birth.substring(5, 7)), Integer.parseInt(birth.substring(8)));

            Patient patient = new Patient(id, username, firstname, lastname, password,
                    email, birthdate, gender, phone, address);
            
            if (!storage.addPatient(patient)) {
                return new Response("Patient id already exists.", Status.CONFLICT);
            }
            
            persistence.save(UserStorage.getInstance());
            
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", patient.getId());
            data.put("username", patient.getUsername());
            data.put("firstname", patient.getFirstname());
            data.put("lastname", patient.getLastname());
            return new Response("Registration successful.", Status.CREATED, data);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Response update(long id, String username, String firstname,
            String lastname, String password, String passwordConfirm, String email,
            String birth, int gender_ind, String phone_str, String address) {
        try {
            Patient existing = storage.getPatient(id);
            if (existing == null) {
                return new Response("Patient not found.", Status.NOT_FOUND);
            }

            Response error;

            if (hasText(username)) {
                error = validator.validateUsername(username);
                if (error != null) {
                    return error;
                }
                Patient other = storage.getPatientByUsername(username.trim());
                if (other != null && other.getId() != id) {
                    return new Response("Patient username already exists.", Status.CONFLICT);
                }
            }

            if (hasText(email)) {
                error = validator.validateEmail(email);
                if (error != null) {
                    return error;
                }
            }

            if (hasText(phone_str)) {
                error = validator.validatePhone(phone_str);
                if (error != null) {
                    return error;
                }
            }

            if (hasText(birth)) {
                error = validator.validateBirthdate(birth);
                if (error != null) {
                    return error;
                }
            }

            if (gender_ind != 0) {
                error = validator.validateGender(gender_ind);
                if (error != null) {
                    return error;
                }
            }

            boolean passwordProvided = hasText(password);
            boolean confirmProvided = hasText(passwordConfirm);
            if (passwordProvided != confirmProvided) {
                return new Response(
                        "Password and confirmation must both be provided to change the password.",
                        Status.BAD_REQUEST);
            }
            if (passwordProvided) {
                error = validator.validatePassword(password, passwordConfirm);
                if (error != null) {
                    return error;
                }
            }

            LocalDate birthdate = null;
            if (hasText(birth)) {
                birthdate = LocalDate.of(
                        Integer.parseInt(birth.substring(0, 4)),
                        Integer.parseInt(birth.substring(5, 7)),
                        Integer.parseInt(birth.substring(8)));
            }

            Boolean gender = null;
            if (gender_ind != 0) {
                gender = (gender_ind == 1);
            }

            Long phone = null;
            if (hasText(phone_str)) {
                phone = Long.parseLong(phone_str.trim());
            }

            if (!storage.updatePatient(
                    id,
                    username,
                    firstname,
                    lastname,
                    passwordProvided ? password : null,
                    email,
                    birthdate,
                    gender,
                    phone,
                    address)) {
                return new Response("Patient not found.", Status.NOT_FOUND);
            }
            
            persistence.save(UserStorage.getInstance());

            Patient updated = storage.getPatient(id);
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", id);
            data.put("username", updated.getUsername());
            data.put("firstname", updated.getFirstname());
            data.put("lastname", updated.getLastname());
            return new Response("Update successful.", Status.OK, data);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    private static boolean hasText(String value) {
        return value != null && !value.trim().isEmpty();
    }

    @Override
    public Response getPatient(long id) {
        Patient patient = storage.getPatient(id);
        if (patient == null) {
            return new Response("Patient not found.", Status.NOT_FOUND);
        }
        HashMap<String, Object> data = new HashMap<>();
        data.put("id", patient.getId());
        data.put("username", patient.getUsername());
        data.put("firstname", patient.getFirstname());
        data.put("lastname", patient.getLastname());
        data.put("email", patient.getEmail());
        data.put("birthdate", patient.getBirthdate().toString());
        data.put("gender", patient.isGender());
        data.put("phone", patient.getPhone());
        data.put("address", patient.getAddress());
        return new Response("Patient found.", Status.OK, data);
    }

    @Override
    public Response getAllPatients() {
        try {
            var patients = storage.getAllPatients();
            ArrayList<HashMap<String, Object>> patientList = new ArrayList<>();
            for (Patient doc : patients) {
                HashMap<String, Object> data = new HashMap<>();
                data.put("id", doc.getId());
                data.put("fullname", doc.getFirstname() + " " + doc.getLastname());
                patientList.add(data);
            }
            HashMap<String, Object> result = new HashMap<>();
            result.put("patients", patientList);
            return new Response("Patients found.", Status.OK, result);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Response getPatient(String fullname) {
        try {
            Patient patient = storage.getPatientByFullName(fullname);
            if (patient == null) {
                return new Response("Patient not found.", Status.NOT_FOUND);
            }
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", patient.getId());
            data.put("username", patient.getUsername());
            data.put("firstname", patient.getFirstname());
            data.put("lastname", patient.getLastname());
            data.put("email", patient.getEmail());
            data.put("birthdate", patient.getBirthdate().toString());
            data.put("gender", patient.isGender());
            data.put("phone", patient.getPhone());
            data.put("address", patient.getAddress());
            return new Response("Patient found.", Status.OK, data);
        } catch (Exception e) {
            return new Response(e.getMessage(), Status.INTERNAL_SERVER_ERROR);
        }
    }
}
