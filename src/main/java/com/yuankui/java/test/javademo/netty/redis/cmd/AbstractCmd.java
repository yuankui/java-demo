package com.yuankui.java.test.javademo.netty.redis.cmd;

import com.yuankui.java.test.javademo.netty.redis.resp.Response;
import lombok.Getter;

public abstract class AbstractCmd<T extends Response> implements Cmd<T> {

    @Getter
    private String[] args;

    @Override
    public void init(String[] args) {
        this.args = args;
    }
}
