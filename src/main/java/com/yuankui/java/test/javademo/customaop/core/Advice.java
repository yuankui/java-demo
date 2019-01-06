package com.yuankui.java.test.javademo.customaop.core;

public interface Advice {
    Object process(JoinPoint joinPoint);
}
