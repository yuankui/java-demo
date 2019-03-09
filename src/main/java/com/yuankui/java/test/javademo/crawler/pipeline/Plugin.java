package com.yuankui.java.test.javademo.crawler.pipeline;

public interface Plugin<T> {
    String name();
    void init(T config);
    Class<T> configClass();
}
