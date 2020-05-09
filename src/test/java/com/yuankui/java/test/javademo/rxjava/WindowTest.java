package com.yuankui.java.test.javademo.rxjava;

import io.reactivex.Flowable;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class WindowTest {
    static class Order {
        int id;
        int shopId;
        int userId;
        int price;
    }
    @Test
    public void window() {
        Flowable<Order> orderFlow = null;
        orderFlow.window(1, TimeUnit.MINUTES)
                .flatMap(window -> {
                    return window.groupBy(o -> o.shopId)
                            .flatMap(group -> {
                                return group.reduce(0, (sum, order) -> {
                                    return sum + order.price;
                                })
                                        .map(sum -> Pair.of(group.getKey(), sum))
                                        .toFlowable();
                            });
                })
                .subscribe(pair -> {
                    System.out.println(pair.getKey() + " => " + pair.getValue());
                });
    }
    
    
}
