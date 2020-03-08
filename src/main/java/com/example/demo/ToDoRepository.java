package com.example.demo;

import com.example.demo.model.ToDo;


public interface ToDoRepository {

    ToDo save(String createdBy, String id, String todo);
    ToDo findById(String createdBy, String id);
    
}

