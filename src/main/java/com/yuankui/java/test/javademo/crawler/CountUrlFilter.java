package com.yuankui.java.test.javademo.crawler;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 限定抓取次数
 */
@Component
public class CountUrlFilter implements UrlFilter {
    private AtomicLong count = new AtomicLong();
    
    @Override
    public boolean valid(UrlWithDeep urlWithDeep) {
        return false;
    }
}
