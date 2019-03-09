package com.yuankui.java.test.javademo.crawler;

import com.yuankui.java.test.javademo.crawler.plugin.utils.PageCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class Crawler {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CrawlerConfig.class);
        Crawler crawler = context.getBean(Crawler.class);
        crawler.start("http://baidu.com");
    }

    @Autowired
    private PageGetter getter;

    @Autowired
    private PageCache pageCache;

    @Autowired
    private UrlQueue urlQueue;

    @Autowired
    private List<UrlFilter> urlFilters;

    public void start(String start) {
        urlQueue.add(new UrlWithDeep(start, 0));

        urlQueue.onUrl(url -> {
            Optional<Page> page = getter.get(url.getUrl());
            if (!page.isPresent()) {
                return;
            }
            pageCache.put(url.getUrl(), page.get());
            List<UrlWithDeep> childUrls = page.get()
                    .getChildUrls()
                    .stream()
                    .map(c -> new UrlWithDeep(c, url.getDeep() + 1))
                    .filter(c -> urlFilters.stream()
                            .allMatch(filter -> filter.valid(c)))
                    .collect(Collectors.toList());
            
            childUrls.forEach(u -> {
                System.out.println(url.getDeep() + ":" + url.getUrl() + " => " + u.getUrl());
                urlQueue.add(u);
            });
        });
    }
}
