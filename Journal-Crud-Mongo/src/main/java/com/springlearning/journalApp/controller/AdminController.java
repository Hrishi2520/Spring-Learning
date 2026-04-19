package com.springlearning.journalApp.controller;

import com.springlearning.journalApp.cache.AppCache;
import com.springlearning.journalApp.entity.User;
import com.springlearning.journalApp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Tag(name = "Admin API'S")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private AppCache appCache;

    @Operation(summary = "Get all users")
    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers() {
        List<User> all = userService.getAll();

        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Create Admin User")
    @PostMapping("/create-admin-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(summary = "clear app cache")
    @GetMapping("/clear-app-cache")
    public void clearAppCache() {
        appCache.init();
    }

}
