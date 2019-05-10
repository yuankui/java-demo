package com.yuankui.java.test.javademo.netty.redis.cmd;

import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.netty.redis.Cache;
import com.yuankui.java.test.javademo.netty.redis.resp.Response;
import org.springframework.beans.factory.annotation.Autowired;

@Prototype
public class SetCmd extends AbstractCmd<Response>{
    
    @Autowired
    private Cache cache;
    
    @Override
    public String getName() {
        return "set";
    }

    @Override
    public Response call() {
        String key = getArgs()[0];
        String value = getArgs()[1];
        
        cache.set(key, value.getBytes());
        return Response.OK;
    }
}
