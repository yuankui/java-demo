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
        Map<String, Object> beans = context.getBeansWithAnnotation(Aspect.class);
        this.adviceAdapters = beans.values()
                .stream()
                .map(obj -> new AdviceAdapter((Advice) obj))
                .collect(Collectors.toList());
    }
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (AdviceAdapter adapter : adviceAdapters) {
            if (adapter.canWrap(bean)) {
                bean = adapter.wrap(bean);
            }
        }
        return bean;
    }
}
