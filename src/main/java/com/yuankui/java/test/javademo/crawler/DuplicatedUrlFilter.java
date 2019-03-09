package com.yuankui.java.test.javademo.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DuplicatedUrlFilter implements UrlFilter {
    
    @Autowired
    private PageCache pageCache;
    
    @Override
    public boolean valid(UrlWithDeep urlWithDeep) {
        return pageCache.get(urlWithDeep.getUrl()) != null;
    }
}
