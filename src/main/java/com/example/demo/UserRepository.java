package com.example.demo;

import com.example.demo.model.User;


public interface UserRepository {

    void save(User user);
    User findByName(String name);
    void update(User user);
    
}

