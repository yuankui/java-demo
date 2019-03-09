package com.yuankui.java.test.javademo.crawler;

import java.util.List;

public interface Page {
    String getUrl();
    List<String> getChildUrls();
    String getContent();
}
