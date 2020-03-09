package com.example.demo;


import com.example.demo.model.ToDo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ToDoRepositoryImpl implements ToDoRepository {

    @Autowired
    private RedisTemplate<String, ToDo> redisTemplate;

    private HashOperations hashOperations;

    public ToDoRepositoryImpl(RedisTemplate<String, ToDo> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public ToDo save(String createdBy, String id, String todo) {

        
        hashOperations.putIfAbsent("TODOS", createdBy+id, new ToDo(createdBy, id, todo));
        return (ToDo) hashOperations.get("TODOS", createdBy+id);
    
    }

   
    

    @Override
    public ToDo findById(String createdBy, String id) {

        return (ToDo) hashOperations.get("TODOS", createdBy+id);
    }

    
   

    

   


}