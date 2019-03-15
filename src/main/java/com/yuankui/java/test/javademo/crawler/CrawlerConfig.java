package com.yuankui.java.test.javademo.crawler;

import com.yuankui.java.test.javademo.crawler.plugin.utils.PageCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

@Configuration
@ComponentScan
public class CrawlerConfig {
    
    @Bean
    public Queue<Context> contextQueue() {
        return new ArrayBlockingQueue<>(10000);
    }
    
    @Bean
    public PageCache pageCache() {
        Map<String, String> pageMap = new HashMap<>();
        return new PageCache() {
            @Override
            public String get(String url) {
                return pageMap.get(url);
            }

            @Override
            public void put(String url, String page) {
                pageMap.put(url, page);
            }

            @Override
            public Map<String, String> toMap() {
                return pageMap;
            }
        };
    }
}
