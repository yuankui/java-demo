package com.yuankui.java.test.javademo.crawler.pipeline;

public interface Filter<T, C> extends Plugin<C> {
    Dataset<T> filter(Dataset<T> dataset);
}
