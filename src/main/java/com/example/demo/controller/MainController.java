package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Null;

import com.example.demo.UserRepository;
import com.example.demo.model.ToDo;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;

    public MainController(UserRepository userRepository){

        this.userRepository = userRepository;

    }

    
    	
    @RequestMapping(value="/api/todos", method =  RequestMethod.GET)
    public List<ToDo> getTodos(@RequestHeader("APP_USERNAME") String createdBy) {
        return userRepository.findByName(createdBy) != null? userRepository.findByName(createdBy).getTodos() : null;
    }

    @RequestMapping(value="/api/todos", method =  RequestMethod.POST)
    public User insertTodo(@RequestHeader("APP_USERNAME") String createdBy, @RequestBody String jsonObject) {

        User user = userRepository.findByName(createdBy);
        
        if(user==null){

            //save to a new user 
            userRepository.save(new User(createdBy), jsonObject.split(":")[0], jsonObject.split(":")[1]);
        }
        else
        {
            //save to already existing user
            userRepository.save(user, jsonObject.split(":")[0], jsonObject.split(":")[1]);

        }
        
        return user;
        
    }

    @RequestMapping(value="/api/todos/{id}", method =  RequestMethod.GET)
    public ToDo getTodoById( @RequestHeader("APP_USERNAME") String createdBy, @PathVariable(value="id") String id) {

       
        Iterator<ToDo> iterate= userRepository.findByName(createdBy).getTodos().iterator();

        while(iterate.hasNext()){
            
            ToDo todo = iterate.next();
            if(todo.getId().equals(id)){

                

                return todo;
            }
        }
        
        
        return null;
    }
    

    



   


}




