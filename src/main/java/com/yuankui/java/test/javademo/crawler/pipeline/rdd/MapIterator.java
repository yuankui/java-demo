package com.yuankui.java.test.javademo.crawler.pipeline.rdd;

import java.util.Iterator;
import java.util.function.Function;

public class MapIterator<T> implements Iterator<T> {
    private Function<T, T> map;
    private Iterator<T> iterator;

    public MapIterator(Function<T, T> map, Iterator<T> iterator) {
        this.map = map;
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public T next() {
        return map.apply(iterator.next());
    }
}
