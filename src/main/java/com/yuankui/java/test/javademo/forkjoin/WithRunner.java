package com.yuankui.java.test.javademo.forkjoin;

import java.util.function.Function;
import java.util.stream.Stream;

public interface WithRunner<T> {
     T merge(Function<Stream<T>, T> merger);
}
