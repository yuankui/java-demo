package com.yuankui.java.test.javademo.crawler;

public interface UrlFilter {
    boolean valid(UrlWithDeep urlWithDeep);
}
