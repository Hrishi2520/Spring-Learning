package com.springlearning.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void sendEmail(){
        redisTemplate.opsForValue().set("email", "hrishi@gmail.com");
        redisTemplate.opsForValue().get("email");
        int a = 1;
    }
}
