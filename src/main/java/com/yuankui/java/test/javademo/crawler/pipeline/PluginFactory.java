package com.yuankui.java.test.javademo.crawler.pipeline;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PluginFactory {
    
    private ApplicationContext context;
    private Map<String, Class<? extends Plugin>> pluginClassMap;

    @PostConstruct
    public void init() {
        this.pluginClassMap = context.getBeansOfType(Plugin.class)
                .values()
                .stream()
                .collect(Collectors.toMap(
                        Plugin::name,
                        Plugin::getClass
                ));
    }
    
    public  <T extends Plugin> T create(String type, Object config, Class<T> typeClass) {
        Class<? extends Plugin> aClass = pluginClassMap.get(type);
        Plugin plugin = context.getBean(aClass);
        
        if (typeClass.isAssignableFrom(plugin.getClass())) {
            String jsonString = JSON.toJSONString(config);
            Object c = JSON.parseObject(jsonString, plugin.configClass());
            plugin.init(c);

            return (T) plugin;
        }
        throw new RuntimeException("plugin name:" + type + " is not type of " + typeClass);
    }
    
}
