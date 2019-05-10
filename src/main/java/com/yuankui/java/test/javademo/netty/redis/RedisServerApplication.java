package com.yuankui.java.test.javademo.netty.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisServerApplication {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(RedisServerApplication.class);
        RedisServer server = context.getBean(RedisServer.class);

        int port = 6380;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        server.init(port);
        server.run();
    }
}
