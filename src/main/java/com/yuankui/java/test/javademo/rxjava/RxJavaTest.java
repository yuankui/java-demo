package com.yuankui.java.test.javademo.rxjava;

import rx.Observable;

import java.util.List;

public class RxJavaTest {
    public static void main(String[] args) {
        Observable.range(1, 100)
                .map(i -> {
                    return i.toString();
                })
                .toMap(k -> k)
                .toSingle()
                .toBlocking()
                .value();

        String str;

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
