package com.springlearning.journalApp.service;

import com.springlearning.journalApp.entity.User;
import com.springlearning.journalApp.entity.UserPrinciple;
import com.springlearning.journalApp.repository.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class UserDetailsServiceImplTest{

    @InjectMocks
    private UserDetailsServiceImpl detailsService;

    @Mock
    private UserRepo userRepo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void loadUserByUsernameTest() {
        when(userRepo.findByUserName(ArgumentMatchers.anyString()))
                .thenReturn(User.builder().userName("ram").password("cknajdvlw")
                        .roles(new ArrayList<>()).build());
        UserDetails ram = detailsService.loadUserByUsername("ram");
        Assertions.assertNotNull(ram);
    }
}
