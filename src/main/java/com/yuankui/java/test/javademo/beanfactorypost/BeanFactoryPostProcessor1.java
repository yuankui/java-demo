package com.yuankui.java.test.javademo.beanfactorypost;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

@Slf4j
public class BeanFactoryPostProcessor1 implements BeanFactoryPostProcessor {
    public BeanFactoryPostProcessor1() {
        log.info("init");
    }
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerSingleton("hello", "string");
    }
}
