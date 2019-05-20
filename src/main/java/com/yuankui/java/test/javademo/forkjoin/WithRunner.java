package com.yuankui.java.test.javademo.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Stream;

public interface WithRunner<T> {
     T join(Function<Stream<T>, T> joiner) throws ExecutionException, InterruptedException;
}
