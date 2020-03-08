
package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class User implements Serializable{

    private String createdBy;
    private Long id;
    private List<String> todos;
   
   
    public User(String createdBy){

        this.createdBy=createdBy;
        todos = new ArrayList<String>();
        
    }

    public String getName(){
        return createdBy;
    }

    public List<String> getTodos(){

        return todos;
    }

    

  
      
}