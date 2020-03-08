package com.example.demo;

import java.util.Map;

import com.example.demo.model.User;


public interface UserRepository {

    void save(User user, String todo);
    User findByName(String name);
    void update(User user);
    Map<String, User> findAll();
    
}

