package com.yuankui.java.test.javademo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Bean1 {
    @Autowired
    private IFace iFace;
    
    public Bean1(IFace iFace) {
        System.out.println("iFace = " + iFace);
    }
    
    @Autowired
    public void setiFace(IFace iFace) {
        System.out.println("iFace = " + iFace);
    }
}
