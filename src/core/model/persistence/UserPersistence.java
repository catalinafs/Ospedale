/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.model.persistence;

import core.model.IUserStorage;
import core.model.User;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author daniel
 */
public class UserPersistence implements IUserPersistence{
     private final IFileHandler fileHandler;
    private final UserSerializer serializer;
    private final UserDeserializer deserializer;
    private final String filePath;
    
    public UserPersistence(IFileHandler fileHandler, UserSerializer serializer, 
                          UserDeserializer deserializer, String filePath) {
        this.fileHandler = fileHandler;
        this.serializer = serializer;
        this.deserializer = deserializer;
        this.filePath = filePath;
    }
    
    @Override
    public void load(IUserStorage storage) {
        String content = fileHandler.read(filePath);
        if (content == null || content.isEmpty()) return;
        
        JSONArray jsonArray;
        // Check if content starts with "{" (object) or "[" (array)
        if (content.trim().startsWith("{")) {
            JSONObject jsonObject = new JSONObject(content);
            jsonArray = jsonObject.getJSONArray("users");
        } else {
            jsonArray = new JSONArray(content);
        }
        
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            User user = deserializer.deserialize(json);
            if (user != null) storage.add(user);
        }
    }
    @Override
    public void save(IUserStorage storage) {
        JSONArray jsonArray = new JSONArray();
        for (User user : storage.getStorage()) {
            JSONObject json = serializer.serialize(user);
             if (json != null) jsonArray.put(json);
        }
        fileHandler.write(filePath, jsonArray.toString());
    }
}
