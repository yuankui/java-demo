package com.yuankui.java.test.javademo.customaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class FetcherTest {

    @Autowired
    private Fetcher fetcher1;
    
    @Test
    public void fetch() {
        Object hello = fetcher1.fetch("hello");

        System.out.println("hello = " + hello);
    }
}