package com.yuankui.java.test.javademo.netty.redis;

import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.netty.redis.obj.RedisCmd;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

@Prototype
public class CmdHandler extends ChannelInboundHandlerAdapter { // (1)

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        RedisCmd cmd = (RedisCmd) msg;
        System.out.println("cmd = " + cmd);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
