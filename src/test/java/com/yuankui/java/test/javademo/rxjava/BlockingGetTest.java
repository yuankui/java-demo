package com.yuankui.java.test.javademo.rxjava;

import io.reactivex.Flowable;
import org.junit.Test;

import java.util.List;

public class BlockingGetTest {

    @Test
    public void test() {
        List<Integer> list = Flowable.range(0, 100)
                .map(i -> {
                    return i + 1;
                })
                .toList()
                .blockingGet();
    }
}
