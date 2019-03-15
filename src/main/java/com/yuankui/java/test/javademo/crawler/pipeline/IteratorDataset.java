package com.yuankui.java.test.javademo.crawler.pipeline;

import java.util.Iterator;

public class IteratorDataset<T> implements Dataset<T> {
    private Iterator<T> iterator;

    public IteratorDataset(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    public IteratorDataset(Iterable<T> iterable) {
        this.iterator = iterable.iterator();
    }

    @Override
    public Iterator<T> iterator() {
        return iterator;
    }
}
