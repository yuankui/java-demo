package com.yuankui.java.test.javademo.threadpool;

public interface RejectedExecutionHandler {
    
    void rejectedExecution(Runnable r, ThreadPool executor);
}
