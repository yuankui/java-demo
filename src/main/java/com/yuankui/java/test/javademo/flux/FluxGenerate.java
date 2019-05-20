package com.yuankui.java.test.javademo.flux;

import reactor.core.publisher.Flux;

public class FluxGenerate {
    public static void main(String[] args) {
        Flux<String> flux = Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });
    }
}
