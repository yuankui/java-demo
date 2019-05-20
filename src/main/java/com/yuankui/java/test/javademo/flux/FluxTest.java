package com.yuankui.java.test.javademo.flux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class FluxTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("hello", "kitty");

        Integer max = Flux.fromIterable(strings)
                .map(String::length)
                .reduce(Math::max)
                .block();

        Mono<Mono<String>> mono = null;
        Mono<String> handle = mono.handle((stringMono, synchronousSink) -> stringMono.subscribe(synchronousSink::next));

        System.out.println("max = " + max);
    }

    private static void test1() {
        Flux<Byte> bytes = Flux.fromStream("1234567890".chars().boxed())
                .map(Integer::byteValue);

        bytes.limitRate(100, 100)
                .buffer(4)
                .map(FluxTest::mergeBytesToInt)
                .subscribe(list -> System.out.println("int = " + list));
    }

    private static int mergeBytesToInt(List<Byte> bytes) {
        return bytes.stream()
                .mapToInt(Byte::intValue)
                .reduce(0, (a, b) -> a * 256 + b);
    }

    private static <S> Flux<List<S>> handle(Flux<S> flux) {
        int size = 3;
        List<S> buf = new ArrayList<>();
        BiConsumer<S, SynchronousSink<List<S>>> buffer = (s, r) -> {
            buf.add(s);
            if (buf.size() >= size) {
                r.next(buf);
                buf.clear();
            }
        };

        return flux.handle(buffer);
    }

}
