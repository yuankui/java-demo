package com.yuankui.java.test.javademo.netty.redis.cmd;

import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.netty.redis.Cache;
import com.yuankui.java.test.javademo.netty.redis.resp.GetResponse;

@Prototype
public class GetCmd extends AbstractCmd<GetResponse>{
    private Cache cache;
    
    @Override
    public String getName() {
        return "get";
    }

    @Override
    public GetResponse call() {
        String key = getArgs()[0];
        Object value = cache.get(key);
        
    }
}
