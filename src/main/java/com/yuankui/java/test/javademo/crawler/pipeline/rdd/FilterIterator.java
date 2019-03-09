package com.yuankui.java.test.javademo.crawler.pipeline.rdd;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterIterator<T> implements Iterator<T> {
    private Predicate<T> filter;
    private Iterator<T> iterator;
    private T item = null;

    public FilterIterator(Predicate<T> filter, Iterator<T> iterator) {
        this.filter = filter;
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        if (item != null) {
            return true;
        }
        
        while(iterator.hasNext()) {
            T next = iterator.next();
            boolean test = this.filter.test(next);
            if (test) {
                this.item = next;
                return true;
            }
        }
        return iterator.hasNext();
    }

    @Override
    public T next() {
        T item = this.item;
        if (item != null) {
            this.item = null;
            return item;
        } else {
            return iterator.next();
        }
    }
}
