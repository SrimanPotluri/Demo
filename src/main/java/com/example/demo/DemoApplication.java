package com.example.demo;

import com.example.demo.model.ToDo;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootApplication
public class DemoApplication {



	@Value("${redis.hostname}")
    private String redisHostName;
 
    @Value("${redis.port}")
    private int redisPort;
 
  

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHostName, redisPort);
		return new JedisConnectionFactory(redisStandaloneConfiguration);
	}

	@Bean
	RedisTemplate<String, User> redisTemplate() {

		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	@Bean
	RedisTemplate<String, ToDo> redisTemplate2() {

		RedisTemplate<String, ToDo> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
