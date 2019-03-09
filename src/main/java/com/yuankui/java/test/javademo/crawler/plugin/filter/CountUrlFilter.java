package com.yuankui.java.test.javademo.crawler.plugin.filter;

import com.yuankui.java.test.javademo.crawler.Context;
import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.crawler.pipeline.Dataset;
import com.yuankui.java.test.javademo.crawler.pipeline.Filter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 限定抓取次数
 */
@Prototype
public class CountUrlFilter implements Filter<Context, Long> {
    private AtomicLong count = new AtomicLong();
    private Long maxCount;

    @Override
    public void init(Long config) {
        this.maxCount = config;
    }

    @Override
    public Dataset<Context> filter(Dataset<Context> dataset) {
        return dataset.filter(context -> count.addAndGet(1) < maxCount);
    }

    @Override
    public Class<Long> configClass() {
        return Long.class;
    }
}
