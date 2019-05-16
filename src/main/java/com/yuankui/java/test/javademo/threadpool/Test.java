package com.yuankui.java.test.javademo.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> future = new FutureTask<>(() -> {
            TimeUnit.SECONDS.sleep(3);
            return "hello";
        });
        
        new Thread(future).start();


        String s = future.get(1, TimeUnit.SECONDS);

    }
}
