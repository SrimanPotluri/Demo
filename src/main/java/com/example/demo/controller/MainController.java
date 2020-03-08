package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import com.example.demo.UserRepository;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;

    public MainController(UserRepository userRepository){

        this.userRepository = userRepository;

    }
    	
    @RequestMapping(value="/api/todos", method =  RequestMethod.GET)
    public List<String> getTodos(@RequestHeader("APP_USERNAME") String createdBy) {
        return userRepository.findByName(createdBy) != null? userRepository.findByName(createdBy).getTodos() : null;
    }

    @RequestMapping(value="/api/todos", method =  RequestMethod.POST)
    public User insertTodo(@RequestHeader("APP_USERNAME") String createdBy, @RequestBody String jsonObject) {

        User user = userRepository.findByName(createdBy);
        
        if(user==null){

            //save to a new user 
            userRepository.save(new User(createdBy), jsonObject);
        }
        else
        {
            //save to already existing user
            userRepository.save(user, jsonObject);

        }
        
        return userRepository.findByName(createdBy);
        
    }

    @RequestMapping(value="/api/todos/{id}", method =  RequestMethod.GET)
    public String getTodoById( @RequestHeader("APP_USERNAME") String createdBy, @PathVariable("id") String id) {

        return "its specific id" + String.valueOf(id) ;
    }



   @RequestMapping(value="/findAllUsers", method =  RequestMethod.GET)
    public Map<String, User> findAll() {

        return userRepository.findAll() ;
    }



}




