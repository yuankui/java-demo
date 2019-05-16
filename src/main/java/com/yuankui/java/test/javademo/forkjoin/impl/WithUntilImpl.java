package com.yuankui.java.test.javademo.forkjoin.impl;

import com.yuankui.java.test.javademo.forkjoin.WithRunner;
import com.yuankui.java.test.javademo.forkjoin.WithUntil;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class WithUntilImpl<T> implements WithUntil<T> {
    private final Supplier<T> source;
    private final Function<T, Stream<T>> forkFunc;
    private final Predicate<T> predicate;
    private final ForkJoinPool pool;

    public WithUntilImpl(ForkJoinPool pool, 
                         Supplier<T> source, 
                         Function<T, Stream<T>> forkFunc, 
                         Predicate<T> predicate) {
        this.pool = pool;
        this.source = source;
        this.forkFunc = forkFunc;
        this.predicate = predicate;
    }

    @Override
    public <R> WithRunner<R> run(Function<T, R> runner) {
        return new WithRunnerImpl<>(pool, source, forkFunc, predicate, runner);
    }
}
