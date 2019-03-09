package com.yuankui.java.test.javademo.crawler.pipeline.rdd;

import java.util.Iterator;
import java.util.function.Function;

public class FlatmapIterator<T> implements Iterator<T> {
    private Function<T, Iterable<T>> flatMap;
    private Iterator<T> iterator;
    private Iterator<T> flatted;

    public FlatmapIterator(Function<T, Iterable<T>> flatMap, Iterator<T> iterator) {
        this.flatMap = flatMap;
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        if (flatted.hasNext()) {
            return true;
        }

        while (iterator.hasNext()) {
            T next = iterator.next();
            this.flatted = flatMap.apply(next).iterator();
            if (this.flatted.hasNext()) {
                return true;
            }
        }
        
        return false;
    }

    @Override
    public T next() {
        return flatted.next();
    }
}
