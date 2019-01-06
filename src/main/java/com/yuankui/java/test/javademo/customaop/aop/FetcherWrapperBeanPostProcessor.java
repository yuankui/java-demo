package com.yuankui.java.test.javademo.customaop.aop;

import com.yuankui.java.test.javademo.customaop.Fetcher;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class FetcherWrapperBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Fetcher) {
            return new ResultFetchWrapper((Fetcher) bean);
        }
        return bean;
    }
}
