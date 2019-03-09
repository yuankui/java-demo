package com.yuankui.java.test.javademo.crawler.plugin.output;

import com.yuankui.java.test.javademo.crawler.Context;
import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.crawler.pipeline.Output;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Queue;

@Prototype
public class ConsoleOutput implements Output<Context, Object> {
    @Autowired
    private Queue<Context> queue;

    @Override
    public void output(Context context) {
        System.out.println("get url =>" + context.getTargetUrl());
    }
}
