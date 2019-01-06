package com.yuankui.java.test.javademo.beanfactorypost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class BeanDefinitionRegistryPostProcessor1 implements BeanDefinitionRegistryPostProcessor {
    public BeanDefinitionRegistryPostProcessor1() {
        System.out.println("construct");
    }
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        registry.registerBeanDefinition("beanFactoryPostProcessor2", new RootBeanDefinition(BeanFactoryPostProcessor1.class));
    }
}
