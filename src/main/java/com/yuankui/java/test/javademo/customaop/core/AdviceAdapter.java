package com.yuankui.java.test.javademo.customaop.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Optional;

public class AdviceAdapter {
    private final Method method;
    private final Class clazz;
    private Advice advice;

    private class Wrapper implements InvocationHandler {
        private Advice advice;
        private Object object;

        public Wrapper(Advice advice, Object object) {
            this.advice = advice;
            this.object = object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 代理的调用要经过advice对象封装，当前前提是方法名要匹配
            if (method.equals(AdviceAdapter.this.method)) {
                return advice.process(() -> {
                    try {
                        return method.invoke(object, args);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            } else {
                // 方法名不匹配，就直接退出
                return method.invoke(object, args);
            }
        }
    }
    /**
     * 解析注解中的class，method
     * @param advice
     */
    public AdviceAdapter(Advice advice) {
        this.advice = advice;
        Aspect aspect = advice.getClass().getAnnotation(Aspect.class);
            this.clazz = aspect.cls();
        Optional<Method> method = Arrays.stream(aspect.cls().getMethods())
                .filter(m -> m.getName().equals(aspect.method()))
                .findFirst();
        
        if (method.isPresent()) {
            this.method = method.get();
            this.method.setAccessible(true);
        } else {
            throw new RuntimeException("method not found:" + aspect);
        }
    }
    
    public boolean canWrap(Object object) {
        // 必须要实现aspect指定的接口
        if (clazz.isAssignableFrom(object.getClass())) {
            return true;
        }
        return false;
    }
    public Object wrap(Object object) {
        InvocationHandler handler = new Wrapper(advice, object);
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{clazz}, handler);
    }
}
