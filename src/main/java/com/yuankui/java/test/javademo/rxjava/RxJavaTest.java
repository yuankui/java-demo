package com.yuankui.java.test.javademo.rxjava;

import io.reactivex.Flowable;
import rx.subjects.PublishSubject;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RxJavaTest {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = Arrays.asList("hello", "Kitty", "world");

        List<String> newList = Flowable.fromIterable(list)
                .filter(s -> s.startsWith("h"))
                .map(s -> s + "subfix")
                .toList()
                .blockingGet();
    }
}
