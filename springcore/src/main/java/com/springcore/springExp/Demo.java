package com.springcore.springExp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {
    @Value("#{11+22}")
    private int x;

    @Value("#{35}")
    private int y;

    @Value("#{T(java.lang.Math).sqrt(25)}")  //invoking static method with spring expression language
    private double z;

    @Value("#{T(java.lang.Math).PI}")  // invoking staic variable with spring expression language
    private double e;

    @Value("#{new java.lang.String('Hrishikesh Shedge')}")
    private String name;

    @Value("#{new java.lang.Boolean(true)}")
    private boolean present;


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", e=" + e +
                ", name='" + name + '\'' +
                ", present=" + present +
                '}';
    }
}
