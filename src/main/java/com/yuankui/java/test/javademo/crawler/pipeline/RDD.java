package com.yuankui.java.test.javademo.crawler.pipeline;

import java.util.function.Function;
import java.util.function.Predicate;

public interface RDD<T> extends Iterable<T> {
    RDD<T> map();

    RDD<T> filter(Predicate<T> predicate);

    RDD<T> flatMap(Function<T, Iterable<T>> flatFunc);
}
