package com.yuankui.java.test.javademo.crawler.pipeline;

import com.yuankui.java.test.javademo.crawler.pipeline.rdd.FilterIterator;
import com.yuankui.java.test.javademo.crawler.pipeline.rdd.FlatmapIterator;
import com.yuankui.java.test.javademo.crawler.pipeline.rdd.MapIterator;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Dataset<T> {
    default Dataset<T> map(Function<T, T> map) {
        return new IteratorDataset<>(new MapIterator<>(map, iterator()));
    }

    default Dataset<T> filter(Predicate<T> filter) {
        return new IteratorDataset<>(new FilterIterator<>(filter, iterator()));
    }

    default Dataset<T> flatMap(Function<T, Iterable<T>> flatMap) {
        return new IteratorDataset<>(new FlatmapIterator<>(flatMap, iterator()));
    }
    
    default void foreach(Consumer<T> consumer) {
        iterator().forEachRemaining(consumer);
    }
    
    Iterator<T> iterator();
}
