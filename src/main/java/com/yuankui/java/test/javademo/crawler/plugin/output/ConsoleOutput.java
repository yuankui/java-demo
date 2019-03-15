package com.yuankui.java.test.javademo.crawler.plugin.output;

import com.yuankui.java.test.javademo.crawler.Context;
import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.crawler.pipeline.Output;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Prototype
public class ConsoleOutput implements Output<Context, Object> {
    @Override
    public void output(Context context) {
        log.info("[{}|{}]{} => {}", context.getSeq(), 
                context.getParentTotal(),
                context.getReferer(),
                context.getUrl());
    }
}
