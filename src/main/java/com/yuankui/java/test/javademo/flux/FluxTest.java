package com.yuankui.java.test.javademo.flux;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

public class FluxTest {
    public static void main(String[] args) throws InterruptedException {
        Flux<Byte> bytes = Flux.just(1, 2, 3, 4).map(Integer::byteValue);

        Optional<List<Integer>> integers = bytes.buffer(4)
                .map(FluxTest::mergeBytesToInt)
                .collectList()
                .blockOptional();

        System.out.println("integers = " + integers);
    }
    
    private static int mergeBytesToInt(List<Byte> bytes) {
        return bytes.stream().mapToInt(Byte::intValue)
                .reduce(0, (a, b) -> a << 8 + b);
    }
}
