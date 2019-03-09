package com.yuankui.java.test.javademo.crawler;

import org.springframework.stereotype.Component;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class UrlParserImpl implements UrlParser {
    @Override
    public String parse(String current, String newPath) {
        URL url;
        try {
            url = new URL(current);
        } catch (MalformedURLException e) {
            return null;
        }
        if (newPath.startsWith("http://")) {
            return newPath;
        }
        if (newPath.startsWith("https://")) {
            return newPath;
        }
        if (newPath.startsWith("//")) {
            return url.getProtocol() + ":" + newPath;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(url.getProtocol()).append("://")
                .append(url.getHost());
        if (url.getPort() > 0) {
            sb.append(":").append(url.getPort());
        }

        String prefix = sb.toString();
        
        if (newPath.startsWith("/")) {
            return prefix + newPath;
        }
        
        // 当前url以/结尾
        // // http://baidu.com/helo/ + find/this => http://baidu.com/hello/find/this
        if (url.getPath().endsWith("/")) {
            return prefix + url.getPath() + newPath;
        } else {
            // http://baidu.com/helo + find/this => http://baidu.com/find/this 
            return prefix + new File(url.getPath()).getParent() + newPath;
        }
    }
}
