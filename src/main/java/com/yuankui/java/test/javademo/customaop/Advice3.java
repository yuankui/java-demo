package com.yuankui.java.test.javademo.customaop;

import com.yuankui.java.test.javademo.customaop.core.Advice;
import com.yuankui.java.test.javademo.customaop.core.Aspect;
import com.yuankui.java.test.javademo.customaop.core.JoinPoint;
import org.springframework.stereotype.Component;

@Aspect(cls = Fetcher.class, method = "fetch")
@Component
public class Advice3 implements Advice {

    @Override
    public Object process(JoinPoint joinPoint) {
        return "prefix:" + joinPoint.proceed();
    }
}
