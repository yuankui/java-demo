package com.yuankui.java.test.javademo.beanpostprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfig {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanpostprocessor/config.xml");

        System.out.println("context = " + context);
    }
}
