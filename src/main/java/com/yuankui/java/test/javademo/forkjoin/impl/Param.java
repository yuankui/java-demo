package com.yuankui.java.test.javademo.forkjoin.impl;

import lombok.Data;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Data
public class Param<S, T, R> {
    private ForkJoinPool pool;
    private S source;
    private Function<S, Stream<R>> forkFunc;
    private Predicate<T> predicate;
    private Function<T, R> runner;
    private Function<Stream<R>, R> merger;
}
