package com.yuankui.java.test.javademo.customaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(AopConfig.class)
public class FetcherTest {

    @Autowired
    private Fetcher fetcher1;
    
    @Test
    public void fetch() {
        Object ret = fetcher1.fetch("hello");

        System.out.println("ret = " + ret);
    }
    
    @Autowired
    private List<Fetcher> fetchers;
    
    @Test
    public void fetchers() {
        for (Fetcher fetcher : fetchers) {
            System.out.println("fetcher.fetch(\"param\") = " + fetcher.fetch("param"));
        }
    }
}