package com.yuankui.java.test.javademo.rxjava;

import io.reactivex.Flowable;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SlidingWindowTest {
    @Test
    public void slidingWindow() {
        Flowable<String> source = Flowable.range(0, 100)
                .map(i -> i.toString());

        Flowable<List<String>> windowFlow = source
                .buffer(3, 1)
                .filter(strings -> strings.size() > 1);

        windowFlow.subscribe(w -> {
            System.out.println("w = " + w);
        });
    }
    
    @Test
    public void timeSlidingWindow() {
        Random random = new Random();
        Flowable<Integer> source = Flowable.interval(500, TimeUnit.MILLISECONDS)
                .map(i -> random.nextInt(100));
        
        source.blockingSubscribe(i -> System.out.println("i = " + i));
    }
}
