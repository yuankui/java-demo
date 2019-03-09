package com.yuankui.java.test.javademo.crawler;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Crawler {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(CrawlerConfig.class);
        Crawler crawler = context.getBean(Crawler.class);
        crawler.run();
    }
    
    public void run() {
        
    }
}
