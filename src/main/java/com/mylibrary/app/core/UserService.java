package com.mylibrary.app.core;

import com.mylibrary.app.api.User;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.UUID;

public class UserService {
    private HashMap<String, User> users = new HashMap<String, User>();

    public User createUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        users.put(userId, user);
        return user;
    }

    public User putUser(User user, String id) {
        user.setId(id); //если это убрать, то Value остается без id(значение id в строке null), элемент с таким id есть
        //users.put(id, user);
        users.replace(id, user);
        return users.get(id);
    }

    public User getUser(String id) {
        return users.get(id);
    }

    public Object[] getUsers() {
//      return users;
        return users.entrySet().toArray();
//      return users.forEach((key, value) -> System.out.println(key + " : " + value));
    }

//    private String allUsers(item){
//        for(Map.Entry<Integer, String> item : item.entrySet()){
//
//            System.out.printf("Key: %d  Value: %s \n", item.getKey(), item.getValue());
//        }
//    }
}