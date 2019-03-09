package com.yuankui.java.test.javademo.crawler;

import org.springframework.stereotype.Component;

@Component
public class DeepUrlFilter implements UrlFilter {
    private int maxDeep = 10;
    
    @Override
    public boolean valid(UrlWithDeep urlWithDeep) {
        if (urlWithDeep.getDeep() > maxDeep) {
            return false;
        }
        return true;
    }
}
