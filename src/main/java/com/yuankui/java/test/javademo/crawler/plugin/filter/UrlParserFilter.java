package com.yuankui.java.test.javademo.crawler.plugin.filter;

import com.yuankui.java.test.javademo.crawler.Context;
import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.crawler.plugin.utils.UrlParser;
import com.yuankui.java.test.javademo.crawler.pipeline.Dataset;
import com.yuankui.java.test.javademo.crawler.pipeline.Filter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Prototype
@Slf4j
public class UrlParserFilter implements Filter<Context, Object> {
    
    @Autowired
    private UrlParser urlParser;
    
    @Override
    public Dataset<Context> filter(Dataset<Context> dataset) {
        return dataset.map(context -> {
            String target = urlParser.parse(context.getReferer(), context.getUrl());
            context.setUrl(target);
            return context;
        });
    }
}
