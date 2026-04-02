package com.springlearning.journalApp.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Disabled
    @Test
    public void testSalary(){
//        redisTemplate.opsForValue().set("email", "hrishi@gmail.com");
        Object salary = redisTemplate.opsForValue().get("salary");

    }
}
