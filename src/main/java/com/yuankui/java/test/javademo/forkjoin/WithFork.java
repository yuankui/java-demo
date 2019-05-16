package com.yuankui.java.test.javademo.forkjoin;

import java.util.function.Predicate;

public interface WithFork<T> {
    WithUntil<T> until(Predicate<T> predicate);
}
