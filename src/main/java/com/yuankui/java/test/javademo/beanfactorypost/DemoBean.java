package com.yuankui.java.test.javademo.beanfactorypost;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Data
@Component
public class DemoBean {
    
    public DemoBean() {
        System.out.println("construct");
    }
    
    @Resource(name = "hello")
    private String name;
    
    public void init() {
        System.out.println("name = " + name);
    }
}
