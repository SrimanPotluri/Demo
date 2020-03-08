package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class MainController {

	
    @RequestMapping(value="/api/todos", method =  RequestMethod.GET)
    public String getTodos(@RequestHeader("APP_USERNAME") String createdBy) {

        return "Lot of todos";
    }

    @RequestMapping(value="/api/todos", method =  RequestMethod.POST)
    public String insertTodo(@RequestHeader("APP_USERNAME") String createdBy, @RequestBody String jsonObject) {


        return "Lot of todos" + createdBy + jsonObject;
    }

    @RequestMapping(value="/api/todos/{id}", method =  RequestMethod.GET)
    public String getTodoById( @RequestHeader("APP_USERNAME") String createdBy, @PathVariable("id") String id) {

        return "its specific id" + String.valueOf(id) ;
    }


}




