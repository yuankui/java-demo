package com.yuankui.java.test.javademo.customaop.aop;

import com.yuankui.java.test.javademo.customaop.Fetcher;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class FetcherWrapperBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 每当spring要创建一个Fetcher实例的时候，我们就用一个FetcherWrapper去包装他
        // 代理模式
        // 实际上，springAOP用的代理模式
        if (bean instanceof Fetcher) {
            return new ResultFetchWrapper((Fetcher) bean);
        }
        return bean;
    }
}
