/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model.persistence;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author daniel
 */
public class FileHandler implements IFileHandler{
    @Override
    public String read(String path) {
        try (FileReader reader = new FileReader(path)) {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                sb.append((char) c);
            }
            return sb.toString();
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage() + " reading to: " + path);
            return null;
        }
    }
    
    @Override
    public void write(String path, String content) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage() + " writing to: " + path);
        }
    }
}
