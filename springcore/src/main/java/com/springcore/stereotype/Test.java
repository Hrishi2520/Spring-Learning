package com.springcore.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("stereotype.xml");
        Employee employee = context.getBean("employee", Employee.class);
        System.out.println(employee);
        System.out.println("---------------------");
        System.out.println(employee.getAddres());

        System.out.println(employee.hashCode());
        Employee employe2 = context.getBean("employee", Employee.class);
        System.out.println(employe2.hashCode());
        System.out.println("---------------------");
        Teacher teacher1 = context.getBean("teacher", Teacher.class);
        Teacher teacher2 = context.getBean("teacher", Teacher.class);

        System.out.println(teacher1.getClass().hashCode());
        System.out.println(teacher2.getClass().hashCode());
    }
}
