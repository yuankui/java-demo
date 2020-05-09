package com.yuankui.java.test.javademo.rxjava;

import io.reactivex.Flowable;
import org.junit.Test;

import java.util.IntSummaryStatistics;

public class ReduceTest {
    @Test
    public void agg() {
        Flowable.fromArray(1, 3, 2, 4, 20)
                .reduce(new IntSummaryStatistics(), (agg, current) -> {
                    agg.accept(current);
                    return agg;
                })
                .subscribe(agg -> System.out.println("agg = " + agg));
    }
}
