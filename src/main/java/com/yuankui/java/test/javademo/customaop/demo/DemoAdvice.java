package com.yuankui.java.test.javademo.customaop.demo;

import com.yuankui.java.test.javademo.customaop.Fetcher;
import com.yuankui.java.test.javademo.customaop.core.Advice;
import com.yuankui.java.test.javademo.customaop.core.Aspect;
import com.yuankui.java.test.javademo.customaop.core.JoinPoint;
import org.springframework.stereotype.Component;

@Aspect(cls = Fetcher.class, method = "fetch")
@Component
public class DemoAdvice implements Advice {

    @Override
    public Object process(JoinPoint joinPoint) {
        System.out.println("before fetcher");
        return joinPoint.proceed();
    }
}
