
package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;





public class User implements Serializable{

    private String createdBy;
    private Long id;
    private List<ToDo> todos;
   
   
    public User(String createdBy){

        this.createdBy=createdBy;
        todos = new ArrayList<ToDo>();
        
    }

    public String getName(){
        return createdBy;
    }

    public List<ToDo> getTodos(){

        return todos;
    }

    

  
      
}