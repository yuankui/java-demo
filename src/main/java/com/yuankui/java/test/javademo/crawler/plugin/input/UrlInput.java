package com.yuankui.java.test.javademo.crawler.plugin.input;

import com.yuankui.java.test.javademo.crawler.Context;
import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.crawler.pipeline.Dataset;
import com.yuankui.java.test.javademo.crawler.pipeline.Input;
import com.yuankui.java.test.javademo.crawler.pipeline.IteratorDataset;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.Queue;

@Prototype
public class UrlInput implements Input<Context, Object> {
    @Autowired
    private Queue<Context> queue;

    @Override
    public Dataset<Context> getItems() {
        return new IteratorDataset<>(new Iterator<Context>() {
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public Context next() {
                return queue.poll();
            }
        });
    }
}
