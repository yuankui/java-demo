package com.yuankui.java.test.javademo.crawler.pipeline;

public interface Input<T, C> extends Plugin<C> {
    RDD<T> getItems();
}
