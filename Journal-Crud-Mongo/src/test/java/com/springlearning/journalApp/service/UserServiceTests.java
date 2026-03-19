package com.springlearning.journalApp.service;

import com.springlearning.journalApp.repository.UserRepo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepo userRepo;

    @ParameterizedTest
    @ValueSource(strings = {
            "ram"
    })
    public void testFindByUserName(String name){
        assertEquals(4, 2+2);
        assertNotNull(userRepo.findByUserName(name), "failed for: "+name);
    }
}
