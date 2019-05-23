package com.yuankui.java.test.javademo.rxjava;

import rx.Observable;

public class RxJavaTest {
    public static void main(String[] args) {
        Observable.range(1, 100)
                .map(i -> {
                    return i.toString();
                })
                .toMap(k -> k)
                .toSingle()
                .toBlocking()
                .value();
    }
}
