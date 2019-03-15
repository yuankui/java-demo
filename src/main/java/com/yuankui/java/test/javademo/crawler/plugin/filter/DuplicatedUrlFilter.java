package com.yuankui.java.test.javademo.crawler.plugin.filter;

import com.yuankui.java.test.javademo.crawler.Context;
import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.crawler.pipeline.Dataset;
import com.yuankui.java.test.javademo.crawler.pipeline.Filter;
import com.yuankui.java.test.javademo.crawler.plugin.utils.PageCache;
import org.springframework.beans.factory.annotation.Autowired;

@Prototype
public class DuplicatedUrlFilter implements Filter<Context, Object> {
    
    @Autowired
    private PageCache pageCache;

    @Override
    public Dataset<Context> filter(Dataset<Context> dataset) {
        return dataset.filter(context -> pageCache.get(context.getUrl()) == null);
    }
}
