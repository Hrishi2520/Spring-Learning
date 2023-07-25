package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Example {

    private String subject;

    public Example() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @PostConstruct
    public void start() {
        System.out.println("Starting method");
    }

    @PreDestroy
    public void end() {
        System.out.println("Ending Method");
    }
    @Override
    public String toString() {
        return "Example [" +
                "subject='" + subject + '\'' +
                ']';
    }
}
