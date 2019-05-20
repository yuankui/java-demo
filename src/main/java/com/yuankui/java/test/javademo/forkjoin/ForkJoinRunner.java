package com.yuankui.java.test.javademo.forkjoin;


public interface ForkJoinRunner {
    <T> WithSource<T> source(T source);
}
