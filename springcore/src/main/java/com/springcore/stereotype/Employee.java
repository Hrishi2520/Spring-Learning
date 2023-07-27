package com.springcore.stereotype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
    @Value("${some.key:10}")
    private int id;
    @Value("${some.key:Kunal}")
    private String name;
    @Value("Pune")
    private String address;
    @Value("${some.key:true}")
    private  boolean isEmployed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isEmployed() {
        return isEmployed;
    }

    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", address= '" + address + '\'' +
                ", isEmployed= " + isEmployed +
                '}';
    }
}
