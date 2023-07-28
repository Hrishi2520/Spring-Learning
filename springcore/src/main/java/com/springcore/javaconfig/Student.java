package com.springcore.javaconfig;

public class Student {
    public void study() {
        System.out.println("student is reading book");
    }

    private Samosa samosa;

    public Samosa getSamosa() {
        return samosa;
    }

    public void setSamosa(Samosa samosa) {
        this.samosa = samosa;
    }

    public Student(Samosa samosa) {
        this.samosa = samosa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "samosa=" + samosa +
                '}';
    }
}
