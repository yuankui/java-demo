package com.yuankui.java.test.javademo.crawler.pipeline;

public interface Filter<T, C> extends Plugin<C> {
    Iterable<T> filter(T t);
}
