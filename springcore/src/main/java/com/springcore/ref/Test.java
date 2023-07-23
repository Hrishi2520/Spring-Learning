package com.springcore.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("refconf.xml");

        Employee emp = (Employee) context.getBean("emp");

        System.out.println(emp.getEmpId());
        System.out.println(emp.getEmpName());
        System.out.println(emp.getContact());
//        System.out.println(emp);
    }
}
