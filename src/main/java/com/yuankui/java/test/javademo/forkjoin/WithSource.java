package com.yuankui.java.test.javademo.forkjoin;

import java.util.function.Function;
import java.util.stream.Stream;

public interface WithSource<T> {
    WithFork<T> fork(Function<T, Stream<T>> forkFunc);

    <R> WithSource<R> map(Function<T, R> mapper);
}
