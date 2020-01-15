package com.yuankui.java.test.javademo.rxjava;

import rx.subjects.PublishSubject;

import java.util.concurrent.TimeUnit;

public class RxJavaTest {
    public static void main(String[] args) throws InterruptedException {
        PublishSubject<String> subject = PublishSubject.create();

        subject.map(s -> s + ":" + s.length())
                .subscribe(a -> System.out.println("a = " + a));
        
        subject.onNext("hello1");
        subject.onNext("hello2");
        subject.onNext("hello3");
        subject.onNext("hello4");

        TimeUnit.SECONDS.sleep(5);
        
        
        subject.onCompleted();
        
        TimeUnit.SECONDS.sleep(4);
    }
}
