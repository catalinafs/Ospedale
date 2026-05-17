/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.model.persistence;

import core.model.IUserStorage;

/**
 *
 * @author daniel
 */
public interface IUserPersistence {
    void load(IUserStorage storage);
    void save(IUserStorage storage);
}