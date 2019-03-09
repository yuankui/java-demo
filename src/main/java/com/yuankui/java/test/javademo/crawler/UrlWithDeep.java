package com.yuankui.java.test.javademo.crawler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UrlWithDeep {
    private String url;
    private int deep;
}
