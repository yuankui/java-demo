package com.yuankui.java.test.javademo.rxjava;

import rx.Observable;

import java.util.concurrent.TimeUnit;

public class RxJavaTest {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> observable = Observable.interval(1, TimeUnit.SECONDS)
                .publish()
                .refCount();


        observable.subscribe(a -> System.out.println("1 = " + a));

        TimeUnit.SECONDS.sleep(5);

        observable.subscribe(a -> System.out.println("2 = " + a));
        
        TimeUnit.SECONDS.sleep(5);
    }
}
