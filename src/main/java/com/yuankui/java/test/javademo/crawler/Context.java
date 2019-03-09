package com.yuankui.java.test.javademo.crawler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Context {
    private int srcDeep;
    private String srcUrl;
    private String targetUrl;
    private String content;
}
