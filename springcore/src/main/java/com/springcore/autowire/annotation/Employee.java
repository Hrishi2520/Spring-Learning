package com.springcore.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
    @Autowired
    @Qualifier("address2")
    private Address address;     //for Property injection
    public Employee() {
    }

//    @Autowired                for constructor injection
    public Employee(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

//    @Autowired                for setter injection
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee [" +
                " address= " + address +
                " ]";
    }
}
