package com.yuankui.java.test.javademo.rxjava;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class CallbackToSingle {
    public static void main(String[] args) {

        Flowable.range(1, 10)
                .flatMap(a -> Single.just(1).toFlowable());
    }
    
}
