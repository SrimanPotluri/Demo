package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;

@Configuration
public class RedisConfig {


    @Bean
    RedisStandaloneConfiguration getRedisConnectionObj() {
        RedisStandaloneConfiguration redisconfig
      = new RedisStandaloneConfiguration("localhost", 6379);

    return redisconfig;
    }

}

