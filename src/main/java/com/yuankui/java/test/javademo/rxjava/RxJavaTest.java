package com.yuankui.java.test.javademo.rxjava;

import rx.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RxJavaTest {
    public static void main(String[] args) {

        Map<String, Integer> map = Observable.from(Arrays.asList("hello", "kitty"))
                .toMap(k -> k, k -> k.length())
                .toBlocking()
                .first();

        System.out.println("map = " + map);
    }

    private static String doIt(List<Integer> list) {
        return list.stream()
                .filter(i -> (i % 2 == 0))
                .map(Object::toString)
                .reduce((left, right) -> left + "; " + right)
                .map(csv -> "[" + csv + "]")
                .orElse("-");
    }

}
