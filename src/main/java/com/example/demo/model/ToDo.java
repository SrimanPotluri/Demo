
package com.example.demo.model;

import java.io.Serializable;

public class ToDo implements Serializable{

    
    private static final long serialVersionUID = 1L;
    
    
    private String createdBy;
    private String todo;
    
   
   
    public ToDo(String createdBy, String todo){

        this.createdBy=createdBy;
        this.todo = todo;
        
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    
      
}