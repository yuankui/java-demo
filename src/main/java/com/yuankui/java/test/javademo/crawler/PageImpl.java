package com.yuankui.java.test.javademo.crawler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageImpl implements Page {
    private String url;
    private List<String> childUrls;
    private String content;
}
