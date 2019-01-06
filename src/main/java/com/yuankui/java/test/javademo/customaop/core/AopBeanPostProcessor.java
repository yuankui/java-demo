package com.yuankui.java.test.javademo.customaop.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AopBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    private ApplicationContext context;
    private List<AdviceAdapter> adviceAdapters;

    @PostConstruct
    public void init() {
        // 搜集切面，保存起来
        Map<String, Object> beans = context.getBeansWithAnnotation(Aspect.class);
        
        // 每一个切面都包含一些行为，这个行为通过AdviceAdapter来封装
        this.adviceAdapters = beans.values()
                .stream()
                .map(obj -> new AdviceAdapter((Advice) obj))
                .collect(Collectors.toList());
    }
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (AdviceAdapter adapter : adviceAdapters) {
            // 看下是否与切面匹配，如果是，就创建代理，否则返回原来的对象
            // 代理模式，装饰器模式，傻傻分不清楚
            if (adapter.canWrap(bean)) {
                bean = adapter.wrap(bean);
            }
        }
        return bean;
    }
}
