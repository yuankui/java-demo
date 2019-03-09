package com.yuankui.java.test.javademo.crawler.pipeline;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface RDD<T> {
    RDD<T> map(Function<T,T> map);

    RDD<T> filter(Predicate<T> predicate);

    RDD<T> flatMap(Function<T, Iterable<T>> flatMap);
    
    default void foreach(Consumer<T> consumer) {
        iterator().forEachRemaining(consumer);
    }
    
    Iterator<T> iterator();
}
