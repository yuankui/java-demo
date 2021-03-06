package com.yuankui.java.test.javademo.crawler.plugin.output;

import com.yuankui.java.test.javademo.crawler.Context;
import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.crawler.pipeline.Dataset;
import com.yuankui.java.test.javademo.crawler.pipeline.Input;
import com.yuankui.java.test.javademo.crawler.pipeline.IteratorDataset;
import com.yuankui.java.test.javademo.crawler.pipeline.Output;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.Queue;

@Prototype
public class UrlOutput implements Output<Context, Object> {
    @Autowired
    private Queue<Context> queue;

    @Override
    public void output(Context context) {
        
        queue.add(context.clone());
    }
}
