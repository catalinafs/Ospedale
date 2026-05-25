/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author daniel
 */
public class HospitalizationStorage implements IHospitalizationStorage{
    private static HospitalizationStorage instance = null;
    private static ArrayList<Hospitalization> hospitalizations = new ArrayList<>();
    private static HashMap<Long, Integer> counters = new HashMap<>();
    private ArrayList<IDataObserver> observers = new ArrayList<>();
    
    private HospitalizationStorage() {}
    
    public static HospitalizationStorage getInstance() {
        if (instance == null) {
            instance = new HospitalizationStorage();
        }
        return instance;
    }
    
    @Override
    public void subscribe(IDataObserver observer) {
        observers.add(observer);
    }
    
    @Override
    public void notifyObservers() {
        for (IDataObserver o : observers) {
            o.onDataChanged("HospitalizationStorage");
        }
    }
    
    @Override
    public Hospitalization getHospitalization(String id) {
        for (Hospitalization h : hospitalizations) {
            if (h.getId().equals(id)) {
                return h;
            }
        }
        return null;
    }
    
    @Override
    public ArrayList<Hospitalization> getAllHospitalizations() {
        return new ArrayList<>(hospitalizations);
    }
    
    @Override
    public String generateHospitalizationId(long patientId) {
        int counter = counters.getOrDefault(patientId, 0);
        String id = String.format("H-%d-%04d", patientId, counter);
        counters.put(patientId, counter + 1);
        return id;
    }
    
    @Override
    public boolean addHospitalization(Hospitalization hospitalization) {
        boolean result = hospitalizations.add(hospitalization);
        notifyObservers();
        return result;
    }
}
