/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.model;

import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public interface IHospitalizationStorage extends IDataObservable {
    public Hospitalization getHospitalization(String id);
    public ArrayList<Hospitalization> getAllHospitalizations();
    public String generateHospitalizationId(long patientId);
    public boolean addHospitalization(Hospitalization hospitalization);
}
