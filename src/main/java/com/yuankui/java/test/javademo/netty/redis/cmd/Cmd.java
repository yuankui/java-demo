package com.yuankui.java.test.javademo.netty.redis.cmd;

import com.yuankui.java.test.javademo.netty.redis.resp.Response;

public interface Cmd<T extends Response> {
    String getName();

    void init(String[] args);

    T call();
}
