package com.yuankui.java.test.javademo.rxjava;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

import java.util.List;

public class SlidingTimeWindow implements Function<Flowable<Integer>, Flowable<List<Integer>>> {
    @Override
    public Flowable<List<Integer>> apply(Flowable<Integer> integerFlowable) throws Exception {
        return null;
    }
}
