package com.yuankui.java.test.javademo.crawler.plugin.utils;

import java.util.Map;

public interface PageCache {
    String get(String url);

    void put(String url, String page);

    Map<String, String> toMap();
}
