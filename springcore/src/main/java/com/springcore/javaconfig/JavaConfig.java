package com.springcore.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

// Declaring Bean with @Bean
    @Bean
    public Samosa getSamosa() {
        return new Samosa();
    }
    @Bean
    public Student getStudent() {
        Student student =new Student(getSamosa());
        return student;
    }
}
