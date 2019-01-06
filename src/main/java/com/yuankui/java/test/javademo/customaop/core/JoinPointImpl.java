package com.yuankui.java.test.javademo.customaop.core;


public class JoinPointImpl implements JoinPoint {
    private Callable callable;
    
    @Override
    public Object proceed() {
        return callable.call();
    }
}
