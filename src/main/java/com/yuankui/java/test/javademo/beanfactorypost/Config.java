package com.yuankui.java.test.javademo.beanfactorypost;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Config {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        DemoBean bean = context.getBean(DemoBean.class);

        System.out.println("bean = " + bean);
    }
}
