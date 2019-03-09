package com.yuankui.java.test.javademo.crawler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Configuration
@ComponentScan
public class CrawlerConfig {
    
    @Bean
    public Queue<UrlWithDeep> urlDeep() {
        return new LinkedBlockingQueue<>(10000);
    }
    
    @Bean
    public PageCache pageCache() {
        Map<String, Page> pageMap = new HashMap<>();
        return new PageCache() {
            @Override
            public Page get(String url) {
                return pageMap.get(url);
            }

            @Override
            public void put(String url, Page page) {
                pageMap.put(url, page);
            }

            @Override
            public Map<String, Page> toMap() {
                return pageMap;
            }
        };
    }
}
