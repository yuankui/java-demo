package com.yuankui.java.test.javademo.crawler.plugin.filter;

import com.yuankui.java.test.javademo.crawler.Context;
import com.yuankui.java.test.javademo.crawler.pipeline.Dataset;
import com.yuankui.java.test.javademo.crawler.pipeline.Filter;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Collections;
import java.util.stream.Collectors;

@Slf4j
public class PageGetterFilter implements Filter<Context, Object> {
    @Override
    public Dataset<Context> filter(Dataset<Context> dataset) {
        return dataset.flatMap(context -> {
            Document document;
            try {
                document = Jsoup.connect(context.getSrcUrl()).get();
            } catch (IOException e) {
                log.warn("get url failed: {}", context.getSrcUrl(), e);
                return Collections.emptyList();
            }
            Elements elements = document.select("a");
            return elements.stream()
                    .map(e -> e.attr("href"))
                    .map(u -> new Context(context.getSrcUrl(), u, document.outerHtml()))
                    .collect(Collectors.toList());
        });
    }
}
