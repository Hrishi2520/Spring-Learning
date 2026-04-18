package com.springlearning.journalApp.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Operation(summary = "Home API")
    @GetMapping("/")
    public String healthCheck() {
        return "Home";
    }
}
