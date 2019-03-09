package com.yuankui.java.test.javademo.crawler;

import java.util.Optional;

public interface PageGetter {
    Optional<Page> get(String url);
}
