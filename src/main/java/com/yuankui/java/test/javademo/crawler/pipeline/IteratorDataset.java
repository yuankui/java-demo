package com.yuankui.java.test.javademo.crawler.pipeline;

import com.yuankui.java.test.javademo.crawler.pipeline.rdd.FilterIterator;
import com.yuankui.java.test.javademo.crawler.pipeline.rdd.FlatmapIterator;
import com.yuankui.java.test.javademo.crawler.pipeline.rdd.MapIterator;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class IteratorDataset<T> implements Dataset<T> {
    private Iterator<T> iterator;

    public IteratorDataset(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public Dataset<T> map(Function<T, T> map) {
        return new IteratorDataset<>(new MapIterator<>(map, iterator));
    }

    @Override
    public Dataset<T> filter(Predicate<T> filter) {
        return new IteratorDataset<>(new FilterIterator<>(filter, iterator));
    }

    @Override
    public Dataset<T> flatMap(Function<T, Iterable<T>> flatMap) {
        return new IteratorDataset<>(new FlatmapIterator<>(flatMap, iterator));
    }

    @Override
    public Iterator<T> iterator() {
        return iterator;
    }
}
