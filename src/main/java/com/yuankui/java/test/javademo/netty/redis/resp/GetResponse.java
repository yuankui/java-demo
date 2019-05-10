package com.yuankui.java.test.javademo.netty.redis.resp;

import io.netty.buffer.ByteBuf;

public class GetResponse implements Response {
    private byte[] value;
    private static final byte[] END = "\r\n".getBytes();

    public GetResponse(byte[] value) {
        this.value = value;
    }

    @Override
    public void write(ByteBuf byteBuf) {
        byteBuf.writeChar('$');
        byteBuf.writeBytes(String.valueOf(value.length).getBytes());
        byteBuf.writeBytes(END);
        byteBuf.writeBytes(value);
        byteBuf.writeBytes(END);
    }

    @Override
    public String toString() {
        return new String(value);
    }
}
