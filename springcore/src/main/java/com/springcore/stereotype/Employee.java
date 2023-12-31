package com.springcore.stereotype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class Employee {
    @Value("${some.key:10}")
    private int id;
    @Value("${some.key:Kunal}")
    private String name;
    @Value("Pune")
    private String address;
    @Value("${some.key:true}")
    private  boolean isEmployed;

    @Value("#{addresses}")
    private List<String> addres;

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

    public List<String> getAddres() {
        return addres;
    }

    public void setAddres(List<String> addres) {
        this.addres = addres;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", isEmployed=" + isEmployed +
                ", addres=" + addres +
                '}';
    }
}
