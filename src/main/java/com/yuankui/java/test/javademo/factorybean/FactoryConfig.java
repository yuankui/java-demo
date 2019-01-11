package com.yuankui.java.test.javademo.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryConfig {
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("factorybean/config.xml");
        Bean1 bean = context.getBean(Bean1.class);
        System.out.println("bean = " + bean);
    }
}
