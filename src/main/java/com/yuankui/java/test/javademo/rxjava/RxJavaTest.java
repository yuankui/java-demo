package com.yuankui.java.test.javademo.rxjava;

import rx.Observable;

import java.util.concurrent.TimeUnit;

public class RxJavaTest {
    public static void main(String[] args) {

        Observable.range(1, 100)
                .buffer(1, 2)
                .subscribe(o -> {
                    System.out.println("o = " + o);
                });
    }
}
