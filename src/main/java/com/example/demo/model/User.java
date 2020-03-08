
package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;




@RedisHash("User")
public class User implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    private String createdBy;
    private List<ToDo> todos = new ArrayList<>();
   
   
    public User(String createdBy){

        this.createdBy=createdBy;
       
        
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<ToDo> getTodos() {
        return todos;
    }

    public void setTodos(List<ToDo> todos) {
        this.todos = todos;
    }

    public void addTodos(ToDo todo) {
        
        this.todos.add(todo);
    }

 
    
  
      
}