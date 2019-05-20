package com.yuankui.java.test.javademo.flux;

import reactor.core.publisher.Flux;

import java.util.List;

public class FluxTest {
    public static void main(String[] args) {
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
}
