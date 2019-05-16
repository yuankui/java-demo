package com.yuankui.java.test.javademo.forkjoin.impl;

import com.yuankui.java.test.javademo.forkjoin.WithRunner;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class WithRunnerImpl<T, R> implements WithRunner<R> {
    private final Supplier<T> source;
    private final Function<T, Stream<T>> forkFunc;
    private final Predicate<T> predicate;
    private final Function<T, R> runner;
    private final ForkJoinPool pool;

    public WithRunnerImpl(ForkJoinPool pool,
                          Supplier<T> source,
                          Function<T, Stream<T>> forkFunc,
                          Predicate<T> predicate,
                          Function<T, R> runner) {
        this.pool = pool;
        this.source = source;
        this.forkFunc = forkFunc;
        this.predicate = predicate;
        this.runner = runner;
    }

    @Override
    public R merge(Function<Stream<R>, R> merger) {
        pool.execute(new Task(source.get(), merger));
        return null;
    }
    
    class Task extends RecursiveTask<R> {
        private T source;
        Function<Stream<R>, R> merger;

        Task(T source, Function<Stream<R>, R> merger) {
            this.source = source;
            this.merger = merger;
        }

        @Override
        protected R compute() {
            if (predicate.test(source)) {
                return runner.apply(source);
            }

            Stream<R> rStream = forkFunc.apply(source)
                    .map(s -> new Task(s, merger))
                    .map(ForkJoinTask::fork)
                    .map(ForkJoinTask::join);
            return merger.apply(rStream);
        }
    }
}
