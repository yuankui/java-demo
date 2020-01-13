package com.yuankui.java.test.javademo.rxjava;

import rx.Observable;
import rx.Observer;
import rx.observables.AsyncOnSubscribe;

public class RxJavaTest {
    public static void main(String[] args) throws InterruptedException {
        Observable.create(new AsyncOnSubscribe<Integer, Integer>() {
            @Override
            protected Integer generateState() {
                return 0;
            }

            @Override
            protected Integer next(Integer state, long requested, Observer<Observable<? extends Integer>> observer) {
                Observable<Integer> take = Observable.range(state, Integer.MAX_VALUE)
                        .take((int) requested);
                
                
                state = state + (int)requested;
                observer.onNext(take);
                
                return state;
            }
        })
                .take(10)
                .subscribe(a -> System.out.println("a = " + a));
    }
}
