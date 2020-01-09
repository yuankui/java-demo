package com.yuankui.java.test.javademo.rxjava;

import org.apache.commons.lang3.tuple.Triple;
import rx.Observable;

public class RxJavaTest {
    public static void main(String[] args) throws InterruptedException {
        Observable.range(1, 10)
                .scan(Integer::sum)
                .subscribe(integer -> {
                    System.out.println("integer = " + integer);
                });

        Triple<Integer, String, Integer> triple = Triple.of(1, "", 13);
    }
}
