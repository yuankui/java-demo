package com.yuankui.java.test.javademo.crawler.pipeline;

import com.yuankui.java.test.javademo.crawler.pipeline.rdd.FilterIterator;
import com.yuankui.java.test.javademo.crawler.pipeline.rdd.FlatmapIterator;
import com.yuankui.java.test.javademo.crawler.pipeline.rdd.MapIterator;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class IteratorRDD<T> implements RDD<T> {
    private Iterator<T> iterator;

    public IteratorRDD(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public RDD<T> map(Function<T, T> map) {
        return new IteratorRDD<>(new MapIterator<>(map, iterator));
    }

    @Override
    public RDD<T> filter(Predicate<T> filter) {
        return new IteratorRDD<>(new FilterIterator<>(filter, iterator));
    }

    @Override
    public RDD<T> flatMap(Function<T, Iterable<T>> flatMap) {
        return new IteratorRDD<>(new FlatmapIterator<>(flatMap, iterator));
    }

    @Override
    public Iterator<T> iterator() {
        return iterator;
    }
}
