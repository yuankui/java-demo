package com.yuankui.java.test.javademo.flux;

import reactor.core.publisher.Flux;

public class FluxTest {
    public static void main(String[] args) {
        Flux<Integer> ints = Flux.range(1, 4)
                .map(i -> {
                    if (i <= 3) return i;
                    throw new RuntimeException("Got to 4");
                });
        ints.subscribe(System.out::println,
                error -> System.err.println("Error: " + error));

    }
}
