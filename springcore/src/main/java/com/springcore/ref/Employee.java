package com.springcore.ref;

public class Employee {
    private int empId;
    private String empName;
    private Contact contact;

    public Employee(int empId, String empName, Contact contact) {
        this.empId = empId;
        this.empName = empName;
        this.contact = contact;
    }

    public Employee() {
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", contact=" + contact +
                '}';
    }
}
