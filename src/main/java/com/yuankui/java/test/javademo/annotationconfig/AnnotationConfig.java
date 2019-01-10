package com.yuankui.java.test.javademo.annotationconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AnnotationConfig {
    @Bean
    public Bean1 bean1() {
        Bean1 bean1 = new Bean1();
        bean1.init();
        return bean1;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Bean1 bean = context.getBean(Bean1.class);
        System.out.println("bean = " + bean);
    }
}
