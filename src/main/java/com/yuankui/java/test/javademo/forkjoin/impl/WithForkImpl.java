package com.yuankui.java.test.javademo.forkjoin.impl;

import com.yuankui.java.test.javademo.forkjoin.WithFork;
import com.yuankui.java.test.javademo.forkjoin.WithUntil;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class WithForkImpl<T> implements WithFork<T> {
    private final Function<T, Stream<T>> forkFunc;
    private final ForkJoinPool pool;
    private Supplier<T> source;
    

    public WithForkImpl(ForkJoinPool pool, 
                        Supplier<T> source, 
                        Function<T, Stream<T>> forkFunc) {
        this.pool = pool;
        this.source = source;
        this.forkFunc = forkFunc;
    }

    @Override
    public WithUntil<T> until(Predicate<T> predicate) {
        return new WithUntilImpl<>(pool, source, forkFunc, predicate);
    }
}
