package com.yuankui.java.test.javademo.netty.redis.cmd;

import com.yuankui.java.test.javademo.crawler.Prototype;
import com.yuankui.java.test.javademo.netty.redis.Cache;
import com.yuankui.java.test.javademo.netty.redis.resp.ErrorResponse;
import com.yuankui.java.test.javademo.netty.redis.resp.GetResponse;
import com.yuankui.java.test.javademo.netty.redis.resp.Response;
import org.springframework.beans.factory.annotation.Autowired;

@Prototype
public class GetCmd extends AbstractCmd<Response>{
    
    @Autowired
    private Cache cache;
    
    @Override
    public String getName() {
        return "get";
    }

    @Override
    public Response call() {
        String key = getArgs()[0];
        byte[] value = cache.get(key);
        if (value == null) {
            return new ErrorResponse("no exist");
        }
        return new GetResponse(value);
    }
}
