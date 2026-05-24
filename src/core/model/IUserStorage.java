/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.model;

/**
 *
 * @author daniel
 */
public interface IUserStorage {
    public User get(Long id);
    public User get(String username);
    public User get(String fName, String lName);
    public boolean add(User user);
    public Iterable<User> getStorage();
}
