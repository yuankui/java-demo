package com.yuankui.java.test.javademo.crawler.plugin.filter;

import com.yuankui.java.test.javademo.crawler.Context;
import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.crawler.pipeline.Dataset;
import com.yuankui.java.test.javademo.crawler.pipeline.Filter;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Prototype
@Slf4j
public class PageGetterFilter implements Filter<Context, Object> {
    @Override
    public Dataset<Context> filter(Dataset<Context> dataset) {
        return dataset.flatMap(this::crawl);
    }
    
    private List<Context> crawl(Context context) {
        Document document;
        try {
            log.info("get url: {}", context.getUrl());
            document = Jsoup.connect(context.getUrl()).get();
        } catch (IOException e) {
            log.warn("get url failed: {}", context.getUrl(), e);
            return Collections.emptyList();
        }
        Elements elements = document.select("a");
        AtomicInteger index = new AtomicInteger();
        return elements.stream()
                .map(e -> e.attr("href"))
                .map(u -> {
                    Context c = new Context();
                    c.setDeep(context.getDeep() + 1);
                    c.setUrl(u);
                    c.setSeq(index.addAndGet(1));
                    c.setParentTotal(elements.size());
                    c.setReferer(context.getUrl());
                    c.setContent(document.outerHtml());
                    return c;
                })
                .collect(Collectors.toList());
    }
}
