package com.yuankui.java.test.javademo.customaop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AopConfig {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        Fetcher bean = context.getBean(Fetcher.class);
        Object ret = bean.fetch("hello there");
        System.out.println("ret = " + ret);
    }
}
