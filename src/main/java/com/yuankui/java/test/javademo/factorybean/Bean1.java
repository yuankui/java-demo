package com.yuankui.java.test.javademo.factorybean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Bean1 {
    @PostConstruct
    public void init() {
        System.out.println("initttttttttttttt");
    }
}
