
package com.example.demo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("ToDo")
public class ToDo implements Serializable{

    
   
    private static final long serialVersionUID = 1L;
   
    @Id String id;
    private String todo;
    @Id private String createdBy;
    
   
   
    public ToDo(String createdBy, String id, String todo){

        this.createdBy = createdBy;
        this.id =  id;
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