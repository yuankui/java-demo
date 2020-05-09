package com.yuankui.java.test.javademo.rxjava;

import io.reactivex.Flowable;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

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
        Flowable<Integer> source = Flowable.interval(100, TimeUnit.MILLISECONDS)
                .map(i -> random.nextInt(100));

        Flowable<List<Integer>> windowed = timeSlidingWindow(source, 3000, 1000);
//        source.blockingSubscribe(System.out::println);
        windowed.blockingSubscribe(System.out::println);
    }

    @Data
    static class ValueWithTimestamp<T> {
        private long timestamp;
        private T value;

        public static <T> ValueWithTimestamp of(T value, long timestamp) {
            ValueWithTimestamp<T> i = new ValueWithTimestamp<>();
            i.setValue(value);
            i.setTimestamp(timestamp);
            return i;
        }
    }

    <T> Flowable<List<T>> timeSlidingWindow(Flowable<T> flowable, long size, long step) {

        AtomicLong lastEmitTime = new AtomicLong(System.currentTimeMillis());

        return flowable.scan(new ArrayDeque<ValueWithTimestamp<T>>(), (queue, v) -> {
            long current = System.currentTimeMillis();
            long old = current - size;
            queue.addLast(ValueWithTimestamp.of(v, current));
            Iterator<ValueWithTimestamp<T>> it = queue.iterator();
            while (it.hasNext()) {
                ValueWithTimestamp<T> item = it.next();
                if (item.getTimestamp() < old) {
                    it.remove();
                } else {
                    break;
                }
            }
            return queue;
        })
                .map(queue -> queue.stream().map(i -> i.getValue()).collect(Collectors.toList()))
                .flatMapIterable(list -> {
                    long current = System.currentTimeMillis();
                    if (current - lastEmitTime.get() < step) {
                        return Arrays.asList();
                    } else {
                        lastEmitTime.set(current);
                        return Arrays.asList(list);
                    }
                });
    }
}


