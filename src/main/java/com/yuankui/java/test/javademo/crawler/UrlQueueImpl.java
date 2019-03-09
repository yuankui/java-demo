package com.yuankui.java.test.javademo.crawler;

import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

@Component
public class UrlQueueImpl implements UrlQueue {
    private Queue<UrlWithDeep> queue = new LinkedBlockingQueue<>(1000);
    @Override
    public boolean add(UrlWithDeep url) {
        return queue.add(url);
    }

    @Override
    public void onUrl(Consumer<UrlWithDeep> consumer) {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
            UrlWithDeep url = queue.poll();
            if (url == null) {
                continue;
            }
            consumer.accept(url);
        }
    }
}
