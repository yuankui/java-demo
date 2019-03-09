package com.yuankui.java.test.javademo.crawler;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlParserImplTest {
    @Test
    public void test() throws MalformedURLException {
        URL url = new URL("http://baidu.com/hello/#name=yuankui");

        System.out.println("url.getPort() = " + url.getPort());
    }

}