package com.yuankui.java.test.javademo.crawler;

import java.util.Map;

public interface PageCache {
    Page get(String url);
    void put(String url, Page page);
    Map<String, Page> toMap();
}
