package com.yuankui.java.test.javademo.rxjava;

import rx.Observable;

import java.util.concurrent.TimeUnit;

public class RxJavaTest {
    public static void main(String[] args) throws InterruptedException {

        Observable.interval(500, TimeUnit.MILLISECONDS)
                .buffer(3)
                .subscribe(list -> {
                    System.out.println("list = " + list);
                });

        
        TimeUnit.SECONDS.sleep(20);
    }
}
