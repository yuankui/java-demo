package com.yuankui.java.test.javademo.crawler.plugin.filter;

import com.yuankui.java.test.javademo.crawler.Context;
import com.yuankui.java.test.javademo.crawler.pipeline.Dataset;
import com.yuankui.java.test.javademo.crawler.pipeline.Filter;
import org.springframework.stereotype.Component;

@Component
public class DeepUrlFilter implements Filter<Context, Object> {
    private int maxDeep = 10;

    @Override
    public Dataset<Context> filter(Dataset<Context> dataset) {
        return dataset.filter(context -> context.getSrcDeep() + 1 <= maxDeep);
    }
}
