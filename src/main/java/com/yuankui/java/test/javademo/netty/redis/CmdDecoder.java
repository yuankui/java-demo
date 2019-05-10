package com.yuankui.java.test.javademo.netty.redis;

import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.netty.redis.obj.RedisCmd;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Arrays;

@Prototype
public class CmdDecoder extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        String line = byteBuf.toString(Charset.forName("utf-8"));
        String[] cmd = line.split(" +");
        RedisCmd redisCmd = new RedisCmd(cmd[0], Arrays.copyOfRange(cmd, 1, cmd.length));

        ctx.fireChannelRead(redisCmd);
        byteBuf.release();
    }
}
