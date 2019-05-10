package com.yuankui.java.test.javademo.netty.redis.resp;

import io.netty.buffer.ByteBuf;

public class GetResponse implements Response {
    private String value;

    public GetResponse(String value) {
        this.value = value;
    }

    @Override
    public void write(ByteBuf byteBuf) {
        
    }
}
