package com.yuankui.java.test.javademo.rxjava;

import io.reactivex.Flowable;

import java.util.List;

public class PartitionTest {
    public static void main(String[] args) {
        List<List<Integer>> lists = Flowable.range(1, 100)
                .buffer(10)
                .toList()
                .blockingGet();
    }
}
