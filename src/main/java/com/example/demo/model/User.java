
package com.example.demo.model;

import java.io.Serializable;

public class User  implements Serializable{

    private String name;
    private Long id;
   
    public User(String name){

        this.name=name;
    }

    public String getName(){

        return name;
    }
 
    
}