package com.yuankui.java.test.javademo.customaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Config.class)
public class FetcherTest {

    @Autowired
    private Fetcher fetcher1;
    
    @Test
    public void fetch() {
        Object ret = fetcher1.fetch("hello");

        System.out.println("ret = " + ret);
    }
}