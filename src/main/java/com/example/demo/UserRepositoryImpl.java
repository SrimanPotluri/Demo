package com.example.demo;


import com.example.demo.model.ToDo;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    private HashOperations hashOperations;

    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(User user, String id, String todo) {
        user.addTodos(new ToDo(user.getCreatedBy(), id, todo));

       //only save unique keys to the todos
        
        hashOperations.put("USERS", user.getCreatedBy(), user);
    
    }

    @Override
    public User findByName(String name) {
        return (User) hashOperations.get("USERS", name);
    }

    
   

    

   


}