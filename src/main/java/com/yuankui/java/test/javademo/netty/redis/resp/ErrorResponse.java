package com.yuankui.java.test.javademo.netty.redis.resp;

import io.netty.buffer.ByteBuf;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse implements Response {
    private String msg;
    
    @Override
    public void write(ByteBuf byteBuf) {
        byteBuf.writeChar('-');
        byteBuf.writeBytes(msg.getBytes());
        byteBuf.writeBytes("\r\n".getBytes());
    }
}
