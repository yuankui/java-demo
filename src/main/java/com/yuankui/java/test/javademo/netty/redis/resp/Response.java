package com.yuankui.java.test.javademo.netty.redis.resp;

import io.netty.buffer.ByteBuf;

public interface Response {
    void write(ByteBuf byteBuf);
}
