/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.model.persistence;

/**
 *
 * @author daniel
 */
public interface UserSerializer extends ISerializer{
    void setNext(UserSerializer next);
}
