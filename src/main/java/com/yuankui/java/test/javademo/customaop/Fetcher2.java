package com.yuankui.java.test.javademo.customaop;

import org.springframework.stereotype.Component;

@Component
public class Fetcher2 implements Fetcher {
    @Override
    public Object fetch(String param) {
        return param + " from fetcher 2";
    }
}
