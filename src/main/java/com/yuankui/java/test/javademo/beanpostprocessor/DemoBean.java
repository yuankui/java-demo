package com.yuankui.java.test.javademo.beanpostprocessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DemoBean {
    @Autowired
    private ApplicationContext context;
    
    @PostConstruct
    public void init() {
        System.out.println("context = " + context);
    }
}
