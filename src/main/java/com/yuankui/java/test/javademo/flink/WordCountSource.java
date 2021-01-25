package com.yuankui.java.test.javademo.flink;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class WordCountSource implements SourceFunction<Integer> , Serializable {

    private AtomicInteger i = new AtomicInteger();
    private Random random = new Random();
    
    @Override
    public void run(SourceContext<Integer> ctx) throws Exception {
        while (true) {
            ctx.collect(i.incrementAndGet());
            Thread.sleep(random.nextInt(50));
        }
    }

    @Override
    public void cancel() {
        System.out.println("canceling source");
    }
}

