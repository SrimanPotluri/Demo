package com.example.demo;


import com.example.demo.model.User;


public interface UserRepository {

    void save(User user, String id, String todo);
    User findByName(String name);
    
   
    
}

