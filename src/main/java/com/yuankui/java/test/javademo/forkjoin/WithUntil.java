package com.yuankui.java.test.javademo.forkjoin;

import java.util.function.Function;

public interface WithUntil<T> {
    <R> WithRunner<R> run(Function<T, R> runner);
}
