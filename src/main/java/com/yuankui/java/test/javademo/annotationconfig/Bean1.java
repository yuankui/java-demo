package com.yuankui.java.test.javademo.annotationconfig;

import javax.annotation.PostConstruct;

public class Bean1 {

    @PostConstruct
    public void init() {
        System.out.println("true = " + true);
    }
}
