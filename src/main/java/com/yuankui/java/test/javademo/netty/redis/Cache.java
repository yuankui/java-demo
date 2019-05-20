package com.yuankui.java.test.javademo.netty.redis;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Cache {
    private Map<String, byte[]> cache = new ConcurrentHashMap<>();
    
    public void set(String key, byte[] value) {
        cache.put(key, value);
    }
    
    public byte[] get(String key) {
        return cache.get(key);
    }
}
