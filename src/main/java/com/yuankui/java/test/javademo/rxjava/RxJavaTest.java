package com.yuankui.java.test.javademo.rxjava;

import rx.Observable;

import java.util.concurrent.TimeUnit;

public class RxJavaTest {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .doOnNext(i -> System.out.println("in = " + System.currentTimeMillis() / 1000))
                .delay(l -> Observable.timer(1, TimeUnit.SECONDS))
                .doOnNext(i -> System.out.println("out = " + System.currentTimeMillis() / 1000))
                .subscribe(i -> System.out.println("i = " + i));
        
        TimeUnit.SECONDS.sleep(10);
    }
}
