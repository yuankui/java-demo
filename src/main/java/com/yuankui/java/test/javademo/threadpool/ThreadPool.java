package com.yuankui.java.test.javademo.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadPool {
    private int corePoolSize;
    private int maximumPoolSize;
    private long keepAliveTime;
    private TimeUnit unit;
    private BlockingQueue<Runnable> workQueue;
    private ThreadFactory threadFactory;
    private RejectedExecutionHandler handler;

    private List<Thread> threads = new ArrayList<>();
    public ThreadPool(int corePoolSize, 
                      int maximumPoolSize, 
                      long keepAliveTime, 
                      TimeUnit unit, 
                      BlockingQueue<Runnable> workQueue, 
                      ThreadFactory threadFactory,
                      RejectedExecutionHandler handler) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.unit = unit;
        this.workQueue = workQueue;
        this.threadFactory = threadFactory;
        this.handler = handler;

        IntStream.range(0, corePoolSize)
                .mapToObj(i -> new Thread(() -> {
                    while (true) {
                        try {
                            Runnable poll = workQueue.poll(keepAliveTime, unit);
                            poll.run();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }));
    }

    public <T> Future<T> submit(Callable<T> callable) {
        FutureTask<T> future = new FutureTask<>(callable);
        boolean accept = workQueue.offer(future);
        if (!accept) {
            handler.rejectedExecution(future, this);
        }
        return future;
    }
}
