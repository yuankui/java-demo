package com.yuankui.java.test.javademo.forkjoin.impl;

import com.yuankui.java.test.javademo.forkjoin.ForkJoinRunner;
import com.yuankui.java.test.javademo.forkjoin.WithSource;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinRunnerImpl implements ForkJoinRunner {

    private final ForkJoinPool pool;

    public ForkJoinRunnerImpl(ForkJoinPool pool) {
        this.pool = pool;
    }

    @Override
    public <T> WithSource<T> source(T source) {
        return new WithSourceImpl<>(pool, () -> source);
    }
}
