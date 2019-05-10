package com.yuankui.java.test.javademo.netty.redis.obj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedisCmd {
    private String cmd;
    private String[] args;
}
