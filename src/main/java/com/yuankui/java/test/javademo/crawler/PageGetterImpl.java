package com.yuankui.java.test.javademo.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PageGetterImpl implements PageGetter {
    
    @Autowired
    private UrlParser urlParser;
    
    @Override
    public Optional<Page> get(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("a");
            List<String> urls = elements.stream()
                    .map(e -> e.attr("href"))
                    .map(newUrl -> urlParser.parse(url, newUrl))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            Page page = new PageImpl(url, urls, document.outerHtml());
            return Optional.of(page);
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}
