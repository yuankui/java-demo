package com.yuankui.java.test.javademo.rxjava;

import io.reactivex.Flowable;
import org.junit.Test;

public class CartesianProductTest {

    public Flowable<Flowable<Object>> convert(Flowable<Flowable<Object>> groupFlow) {
        return groupFlow
                .reduce(empty(), (last, currentGroup) -> {
                    return last.flatMap(f -> {
                        return currentGroup.map(o -> {
                            return f.mergeWith(Flowable.just(o));
                        });
                    });
                })
                .toFlowable()
                .flatMap(o -> o);
    }

    private Flowable<Flowable<Object>> empty() {
        return Flowable.just(Flowable.empty());
    }

    @Test
    public void testGroup() {
        Flowable<Flowable<Object>> flowable = Flowable.fromArray(
                Flowable.fromArray(1, 2, 3, 4),
                Flowable.fromArray("A", "B", "C", "D"),
                Flowable.fromArray("X", "Y", "Z")
        );

        convert(flowable)
                .subscribe(flow -> {
                    flow.toList().subscribe(System.out::println);
                });
    }

}
