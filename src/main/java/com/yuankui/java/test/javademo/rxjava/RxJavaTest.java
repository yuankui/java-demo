package com.yuankui.java.test.javademo.rxjava;

import rx.Observable;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.List;

public class RxJavaTest {
    public static void main(String[] args) throws InterruptedException {
        Observable.range(1, 10)
                .flatMap(new Func1<Integer, Observable<List<Integer>>>() {
                    private List<Integer> ints = new ArrayList<>();

                    @Override
                    public Observable<List<Integer>> call(Integer integer) {
                        ints.add(integer);
                        if (ints.size() == 3) {
                            try {
                                return Observable.just(ints);
                            } finally {
                                this.ints = new ArrayList<>();
                            }
                        } else {
                            return Observable.empty();
                        }
                    }
                })
                .subscribe(i -> System.out.println("i = " + i));
    }
}
