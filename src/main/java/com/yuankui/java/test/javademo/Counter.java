package com.yuankui.java.test.javademo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class Counter {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> collect = new BufferedReader(new FileReader("/Users/yuankui/Downloads/tmp.csv"))
                .lines()
                .map(l -> l.split(","))
                .collect(Collectors.groupingBy(l -> l[0], Collectors.mapping(l -> Integer.parseInt(l[1]), Collectors.summingInt(value -> value))));


        collect.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(kv -> {
                    System.out.println(kv.getKey() + " -> " + kv.getValue());
                });

    }
}
