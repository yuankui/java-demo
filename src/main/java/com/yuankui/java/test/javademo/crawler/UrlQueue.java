package com.yuankui.java.test.javademo.crawler;

import java.util.function.Consumer;

public interface UrlQueue {
    boolean add(UrlWithDeep url);

    void onUrl(Consumer<UrlWithDeep> consumer);
}
