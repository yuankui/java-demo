package com.yuankui.java.test.javademo.forkjoin;

import com.yuankui.java.test.javademo.forkjoin.impl.ForkJoinRunnerImpl;

import java.util.concurrent.ForkJoinPool;

/**
 * 1. 如何拆
 * 2. 拆到何时为止
 * 3. 怎么对最小粒度进行计算
 * 4. 拆了之后，如何进行合并
 */
public class Builder {
    public static ForkJoinRunner build(ForkJoinPool pool) {
        return new ForkJoinRunnerImpl(pool);
    }
}
