
package com.example.demo.model;

import java.io.Serializable;

import org.springframework.data.redis.core.index.Indexed;


public class ToDo implements Serializable{

    
   
    private static final long serialVersionUID = 1L;
   
    @Indexed String id;
    private String todo;
    
   
   
    public ToDo(String createdBy, String id, String todo){

       
        this.id = createdBy + "-" + id;
        this.todo = todo;
        
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

   
    
      
}