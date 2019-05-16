package com.yuankui.java.test.javademo.forkjoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Test {
    public static void main(String[] args) {
        String txt = "hello\nkitty\nthis\nis\nyour\ndaddy";
        ForkJoinRunner runner = Builder.build(new ForkJoinPool());
        Integer total = runner.source(txt)
                .fork(urls -> Arrays.stream(urls.split("\n")))
                .until(s -> true)
                .run(String::length)
                .merge(numbers -> numbers.mapToInt(value -> value).sum());

        System.out.println("total = " + total);
    }
}
