package com.springlearning.journalApp.controller;

import com.springlearning.journalApp.dto.UserDto;
import com.springlearning.journalApp.entity.User;
import com.springlearning.journalApp.service.UserDetailsServiceImpl;
import com.springlearning.journalApp.service.UserService;
import com.springlearning.journalApp.utils.JWTUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/public")
@Tag(name = "Public API'S")
public class PublicController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl  userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtils jwtUtils;

    @Operation(summary = "Health Check")
    @GetMapping("/health-check")
    public String healthCheck() {
        return "ok";
    }

    @Operation(summary = "SignUp")
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody UserDto userDto) {
        try {
            User user = new User();
            user.setUserName(userDto.getUserName());
            user.setPassword(userDto.getPassword());
            user.setEmail(userDto.getEmail());
            user.setSentimentAnalysis(userDto.isSentimentAnalysis());
            userService.saveNewUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Login")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
        try {
            User user = new User();
            user.setUserName(userDto.getUserName());
            user.setPassword(userDto.getPassword());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
            String jwt = jwtUtils.generateToken(userDetails.getUsername());
            return new ResponseEntity<>(jwt, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception Occurred While createAuthenticationToken ", e);
            return new ResponseEntity<>("Incorrect Username and Password", HttpStatus.BAD_REQUEST);
        }
    }
}
