package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.ToDoRepository;
import com.example.demo.UserRepository;
import com.example.demo.model.ToDo;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ToDoRepository todoRepository;

    public MainController(UserRepository userRepository, ToDoRepository toDoRepository){

        this.userRepository = userRepository;
        this.todoRepository = toDoRepository;

    }

    	
    @RequestMapping(value="/api/todos", method =  RequestMethod.GET)
    public ResponseEntity<?> getTodos(@RequestHeader("APP_USERNAME") String createdBy) {

        return userRepository.findByName(createdBy) != null? new ResponseEntity<>(userRepository.findByName(createdBy).getTodos(), HttpStatus.OK) : new ResponseEntity<>("user doesn't exist", HttpStatus.OK);
        
    }

    @RequestMapping(value="/api/todos", method =  RequestMethod.POST)
    public ResponseEntity<?> insertTodo(@RequestHeader("APP_USERNAME") String createdBy, @RequestBody String jsonObject) {

        User user = userRepository.findByName(createdBy);
        
        ToDo todo = todoRepository.save(createdBy, jsonObject.split(":")[0], jsonObject.split(":")[1]);

            if(user==null){

                user = new User(createdBy);
            }

            user.addTodos(todo);
            userRepository.save(user);
            
        return new ResponseEntity<>(user, HttpStatus.OK);
        
    }

    
    @RequestMapping(value="/api/todos/{id}", method =  RequestMethod.GET)
    public ResponseEntity<?> getTodoById( @RequestHeader("APP_USERNAME") String createdBy, @PathVariable(value="id") String id) {

        return new ResponseEntity<>(todoRepository.findById(createdBy, id), HttpStatus.OK);
        
    }
    

}




