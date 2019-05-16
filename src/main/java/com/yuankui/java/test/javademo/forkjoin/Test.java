package com.yuankui.java.test.javademo.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int num = 10;
        ForkJoinRunner runner = Builder.build(new ForkJoinPool());
        Integer total = runner.source(num)
                .fork(n -> Stream.of(n-1, n -2))
                .until(n -> n < 2)
                .run(n -> 1)
                .join(numbers -> numbers.mapToInt(value -> value).sum());

        System.out.println("total = " + total);
    }
}
