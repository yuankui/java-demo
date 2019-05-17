package com.yuankui.java.test.javademo.wait;

import java.util.concurrent.TimeUnit;

public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    synchronized (lock) {
                        System.out.println("enter:" + finalI);
                        lock.wait();
                        System.out.println("jstack please");
                        TimeUnit.SECONDS.sleep(3);
                    }
                    System.out.println("exit = " + finalI);
                } catch (Exception e) {
                    System.out.println("exception = " + finalI);
                    e.printStackTrace();
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(2);
        System.out.println("starting");

        synchronized (lock) {
            lock.notifyAll();
        }
    }
}
