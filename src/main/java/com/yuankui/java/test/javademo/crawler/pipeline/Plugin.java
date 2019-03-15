package com.yuankui.java.test.javademo.crawler.pipeline;

public interface Plugin<T> {
    default String name() {
        return this.getClass().getSimpleName();
    }
    default void init(T config) {
        // default do nothing
    }
    default Class<T> configClass() {
        // default no config
        return (Class<T>) Object.class;
    }
}
