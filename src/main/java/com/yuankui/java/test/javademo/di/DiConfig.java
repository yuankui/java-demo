package com.yuankui.java.test.javademo.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DiConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);

        Bean1 bean = context.getBean(Bean1.class);

        System.out.println("bean = " + bean);
    }
}
