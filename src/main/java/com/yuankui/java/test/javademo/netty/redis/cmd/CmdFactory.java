package com.yuankui.java.test.javademo.netty.redis.cmd;

import com.yuankui.java.test.javademo.netty.redis.obj.RedisCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CmdFactory {
    @Autowired
    private ApplicationContext context;
    private Map<String, Class<? extends Cmd>> cmdMap;

    @PostConstruct
    public void init() {
        this.cmdMap = context.getBeansOfType(Cmd.class)
                .values()
                .stream()
                .collect(Collectors.toMap(
                        o -> o.getName(),
                        o -> o.getClass()
                ));
    }
    
    public Cmd get(RedisCmd cmd) {
        Class<? extends Cmd> cmdClass = cmdMap.get(cmd.getCmd());
        if (cmdClass == null) {
            throw new RuntimeException("cmd not support:" + cmd);
        }

        Cmd bean = context.getBean(cmdClass);
        bean.init(cmd.getArgs());
        return bean;
    }
}
