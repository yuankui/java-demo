package com.yuankui.java.test.javademo.crawler.plugin.filter;

import com.yuankui.java.test.javademo.crawler.Context;
import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.crawler.pipeline.Dataset;
import com.yuankui.java.test.javademo.crawler.pipeline.Filter;
import groovy.lang.Closure;
import groovy.lang.GroovyShell;

/**
 * 限定抓取次数
 */
@Prototype
public class GroovyFilter implements Filter<Context, String> {
    private String script;
    private Closure closure;
    
    @Override
    public void init(String config) {
        this.script = config;
        Object closure = new GroovyShell().evaluate(script);
        if (closure instanceof Closure) {
            this.closure = (Closure) closure;
            return;
        }

        throw new RuntimeException("groovy script not return closure:" + config);
    }

    @Override
    public Dataset<Context> filter(Dataset<Context> dataset) {
        return dataset.filter(context -> {
            Object call = closure.call(context);
            return !Boolean.FALSE.equals(call);
        });
    }

    @Override
    public Class<String> configClass() {
        return String.class;
    }
}
