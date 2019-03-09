package com.yuankui.java.test.javademo.crawler.pipeline;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class IteratorDatasetTest {

    @Test
    public void map() {
        Dataset<String> dataset = new IteratorDataset<>(Arrays.asList("hello", "kitty", "find", "hs"));

        Dataset<String> h = dataset.map(s -> s + "sssss");
        h.foreach(s -> System.out.println("s = " + s));
    }

    @Test
    public void filter() {
        Dataset<String> dataset = new IteratorDataset<>(Arrays.asList("hello", "kitty", "find", "hs"));

        Dataset<String> h = dataset.filter(s -> s.startsWith("h"));
        h.foreach(s -> System.out.println("s = " + s));
    }

    @Test
    public void flatMap() {
        Dataset<String> dataset = new IteratorDataset<>(Arrays.asList("yuan,kui,th", "sfds,f", "find", "hs"));

        Dataset<String> h = dataset.flatMap(s -> Arrays.asList(s.split(",")));
        h.foreach(s -> System.out.println("s = " + s));
    }
}