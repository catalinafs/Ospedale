package main;


import com.formdev.flatlaf.FlatDarkLaf;
import core.model.UserStorage;
import core.model.persistence.AdminDeserializer;
import core.model.persistence.AdminSerializer;
import core.model.persistence.DoctorDeserializer;
import core.model.persistence.DoctorSerializer;
import core.model.persistence.FileHandler;
import core.model.persistence.PatientDeserializer;
import core.model.persistence.PatientSerializer;
import core.model.persistence.UserDeserializer;
import core.model.persistence.UserPersistence;
import core.model.persistence.UserSerializer;
import core.view.MainView;
import javax.swing.UIManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        
        UserPersistence persistence = new UserPersistence(new FileHandler(), adminSer, adminDes, "json/users.json");
        persistence.load(UserStorage.getInstance());
        
        System.setProperty("flatlaf.useNativeLibrary", "false");

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }
    
}
