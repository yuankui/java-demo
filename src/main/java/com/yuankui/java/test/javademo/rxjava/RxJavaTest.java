package com.yuankui.java.test.javademo.rxjava;

import rx.Observable;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class RxJavaTest {
    public static void main(String[] args) throws InterruptedException {
        Observable.range(1, 10)
                .lift((Observable.Operator<List<Integer>, Integer>) subscriber -> new Subscriber<Integer>() {
                    private List<Integer> ints = new ArrayList<>();
                    @Override
                    public void onCompleted() {
                        if (!ints.isEmpty()) {
                            subscriber.onNext(ints);
                        }
                        subscriber.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        subscriber.onError(e);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        ints.add(integer);
                        if (ints.size() == 3) {
                            subscriber.onNext(ints);
                            ints = new ArrayList<>();
                        }
                    }
                })
                .subscribe(i -> System.out.println("i = " + i));
    }
}
