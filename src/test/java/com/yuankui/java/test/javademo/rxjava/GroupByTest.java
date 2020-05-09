package com.yuankui.java.test.javademo.rxjava;

import io.reactivex.Flowable;
import org.junit.Test;

import java.util.Arrays;

public class GroupByTest {
    @Test
    public void groupBy() {
        Flowable<Integer> flowable = Flowable.fromArray(1, 2, 3, 4, 5);
        flowable.groupBy(i -> i /3)
                .flatMap(g -> g.toList().toFlowable())
                .subscribe(list -> {
                    System.out.println("group = " + list);
                });
    }
    
    @Test
    public void groupAndSum() {
        Flowable<Integer> flowable = Flowable.range(0, 20);
        flowable.groupBy(i -> i % 2)
                .flatMap(group -> {
                    return group
                            .reduce(Integer::sum)
                            .map(sum -> Arrays.asList(group.getKey(), sum))
                            .toFlowable();
                })
                .subscribe(keyAndSum -> {
                    Integer key = keyAndSum.get(0);
                    Integer sum = keyAndSum.get(1);
                    System.out.println(key + " => " + sum);
                });
    }
}
