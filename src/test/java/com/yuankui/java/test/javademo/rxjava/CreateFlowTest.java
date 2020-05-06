package com.yuankui.java.test.javademo.rxjava;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class CreateFlowTest {
    @Test
    public void create() {
        Flowable<Integer> flowable = Flowable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(99);
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);

        flowable.toList()
                .subscribe(System.out::println);
    }

    @Test
    public void defer() {
        Flowable<Object> flowable = Flowable.defer(() -> {
            System.out.println("Before create flow");
            return s -> {
                s.onNext(1);
                s.onNext(99);
                s.onComplete();
            };
        });

        System.out.println("before first convert");
        Single<List<Object>> listFlow = flowable.toList();

        System.out.println("before subscribe");

        listFlow.subscribe(System.out::println);
        listFlow.subscribe(System.out::println);
    }

    @Test
    public void never() {
        Flowable<Object> never = Flowable.never();

        never.subscribe(System.out::println);
    }

    @Test
    public void fromArray() {
        Flowable<Integer> array = Flowable.fromArray(1, 2, 5, 8);

//        List<Integer> intList = null;
//        Flowable<Integer> array2 = Flowable.fromIterable(intList);

        array.toList()
                .subscribe(System.out::println);
    }

    @Test
    public void interval() throws InterruptedException {
        Flowable.interval(1, TimeUnit.SECONDS)
                .buffer(3)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(12);
    }

    @Test
    public void range() {
        Flowable.range(1, 10)
                .toList()
                .subscribe(System.out::println);
    }

    @Test
    public void timer() throws InterruptedException {

        Flowable<Long> flowable = Flowable.timer(1, TimeUnit.SECONDS);
        flowable.subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(2);
        flowable.subscribe(System.out::println);
        TimeUnit.SECONDS.sleep(2);
    }

    @Test
    public void and() {
        Flowable<Integer> flow1 = Flowable.fromArray(1, 2, 3);
        Flowable<Integer> flow2 = Flowable.fromArray(5, 6, 7);

        Flowable<Integer> flowable = flow1.mergeWith(flow2);

        flowable.toList()
                .subscribe(System.out::println);
    }

    @Test
    public void combineLastest() {
        Flowable<Integer> flow1 = Flowable.fromArray(1, 2, 3);
        Flowable<Integer> flow2 = Flowable.fromArray(5, 6, 7);

        Flowable<String> flowable = flow1.withLatestFrom(flow2, (a, b) -> {
            return a + ":" + b;
        });

        flowable.toList()
                .subscribe(System.out::println);
    }

    @Test
    public void join() {
        Flowable<Integer> flow1 = Flowable.fromArray(1, 2, 3);
        Flowable<Integer> flow2 = Flowable.fromArray(5, 6, 7, 8);

        Flowable<String> flowable = flow1.zipWith(flow2, (a, b) -> {
            return a + ":" + b;
        });

        flowable.toList()
                .subscribe(System.out::println);
    }


    public <T> Flowable<T> merge(Flowable<T> a, Flowable<T> b) {

        return Flowable.create(s -> {
            // 先订阅低一个flow
            a.doOnNext(t -> {
                // 发布元素
                s.onNext(t);
            })
            .doOnComplete(() -> {
                // 第一个flow结束后，开始订阅其中的元素
                b.doOnNext(r -> {
                    // 发布第二个流中的元素
                    s.onNext(r);
                })
                // 当第二个流结束了，就代表整个流结束了。
                .doOnComplete(s::onComplete)
                .subscribe();
            })
            .subscribe();
        }, BackpressureStrategy.BUFFER);
    }

    @Test
    public void demoMerge() throws InterruptedException {
        Flowable<Integer> flow1 = Flowable.fromArray(1, 2, 3);
        Flowable<Integer> flow2 = Flowable.fromArray(10, 20, 30);

        Flowable<Integer> flowable = merge(flow1, flow2);

        flowable.toList().subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void cube() {
        List<List<Integer>> lists = Flowable.range(0, 100)
                .buffer(10)
                .toList()
                .blockingGet();
        
        lists.forEach(l -> {
            System.out.println("l = " + l);
        });
    }
}