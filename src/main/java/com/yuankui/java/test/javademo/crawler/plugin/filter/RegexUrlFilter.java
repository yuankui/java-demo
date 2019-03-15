package com.yuankui.java.test.javademo.crawler.plugin.filter;

import com.yuankui.java.test.javademo.crawler.Context;
import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.crawler.pipeline.Dataset;
import com.yuankui.java.test.javademo.crawler.pipeline.Filter;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Prototype
@Slf4j
public class RegexUrlFilter implements Filter<Context, String> {
    private String regex;
    private Pattern pattern;

    @Override
    public void init(String config) {
        this.regex = config;
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public Class<String> configClass() {
        return String.class;
    }

    @Override
    public Dataset<Context> filter(Dataset<Context> dataset) {
        return dataset.filter(c -> {
            String url = c.getUrl();
            Matcher matcher = pattern.matcher(url);
            return matcher.find();
        });
    }
}
