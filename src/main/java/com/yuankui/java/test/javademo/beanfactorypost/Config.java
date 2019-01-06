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

        Object hello = context.getBean("hello");
        System.out.println("hello = " + hello);
        DemoBean bean = context.getBean(DemoBean.class);

        DemoBean bean1 = context.getBean(DemoBean.class);
        System.out.println("bean = " + bean);
    }
}
