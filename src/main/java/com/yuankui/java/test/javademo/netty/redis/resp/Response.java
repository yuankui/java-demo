package com.yuankui.java.test.javademo.netty.redis.resp;

import io.netty.buffer.ByteBuf;

public interface Response {
    Response OK = byteBuf -> byteBuf.writeBytes(("+OK\r\n".getBytes()));
    void write(ByteBuf byteBuf);
}
