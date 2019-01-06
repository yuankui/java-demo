package com.yuankui.java.test.javademo.di;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Bean2 implements IFace {
    public Bean2() {
        System.out.println("hello bean2");
    }
}
