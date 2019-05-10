package com.yuankui.java.test.javademo.netty.redis;

import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.netty.redis.cmd.Cmd;
import com.yuankui.java.test.javademo.netty.redis.cmd.CmdFactory;
import com.yuankui.java.test.javademo.netty.redis.obj.RedisCmd;
import com.yuankui.java.test.javademo.netty.redis.resp.Response;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.springframework.beans.factory.annotation.Autowired;

@Prototype
public class CmdHandler extends ChannelInboundHandlerAdapter { // (1)
    
    @Autowired
    private CmdFactory cmdFactory;
    
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        RedisCmd cmd = (RedisCmd) msg;
        Cmd c = cmdFactory.get(cmd);
        Response response = c.call();
        ByteBuf buffer = ctx.alloc().buffer();
        response.write(buffer);
        ctx.writeAndFlush(buffer);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
