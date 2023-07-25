package com.springcore.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("samosaconfig.xml");

        Samosa samosa = (Samosa) context.getBean("samosa");
        System.out.println(samosa);

//        registering shutdown hook
        context.registerShutdownHook();
    }


}
