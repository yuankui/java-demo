package com.yuankui.java.test.javademo.crawler.pipeline;

public interface Output<T, C> extends Plugin<C> {
    void output(T t);
}
