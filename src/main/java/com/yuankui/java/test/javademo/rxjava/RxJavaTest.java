package com.yuankui.java.test.javademo.rxjava;

import rx.Observable;

import java.util.List;

public class RxJavaTest {
    public static void main(String[] args) {

        Observable<List<Integer>> buffer = Observable
                .range(1, 100)
                .buffer(4);

        Observable<List<Integer>> defered = Observable.defer(() -> buffer);

        defered.subscribe(o -> System.out.println("o = " + o));
    }
}
