package com.yuankui.java.test.javademo.forkjoin.impl;

import com.yuankui.java.test.javademo.forkjoin.WithFork;
import com.yuankui.java.test.javademo.forkjoin.WithSource;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class WithSourceImpl<T> implements WithSource<T> {
    private Supplier<T> source;
    private ForkJoinPool pool;

    public WithSourceImpl(ForkJoinPool pool, 
                          Supplier<T> source) {
        this.pool = pool;
        this.source = source;
    }
    
    @Override
    public WithFork<T> fork(Function<T, Stream<T>> forkFunc) {
        return new WithForkImpl<>(pool, source, forkFunc);
    }

    @Override
    public <R> WithSource<R> map(Function<T, R> mapper) {
        return new WithSourceImpl<>(pool, () -> mapper.apply(source.get()));
    }
}
