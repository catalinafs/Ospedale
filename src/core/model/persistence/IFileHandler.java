/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.model.persistence;

/**
 *
 * @author daniel
 */
public interface IFileHandler {
    String read(String path);
    void write(String path, String content);
}
