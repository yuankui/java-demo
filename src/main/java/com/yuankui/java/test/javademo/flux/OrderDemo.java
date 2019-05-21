package com.yuankui.java.test.javademo.flux;

import com.yuankui.java.test.javademo.flux.obj.Item;
import com.yuankui.java.test.javademo.flux.obj.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

public class OrderDemo {
    public Mono<Order> getOrder(String id) {
        Mono<Order> cache = getCache(id);
        return cache.filter(Objects::nonNull)
                .switchIfEmpty(getFull(id));
    }

    public Mono<Order> getFull(String id) {
        Flux<Item> items = getItems(id);
        Mono<List<Item>> listMono = items.collectList();
        Mono<Order> main = getMain(id);

        return main.zipWith(listMono)
                .map((tuple) -> {
                    tuple.getT1().setItems(tuple.getT2());
                    return tuple.getT1();
                });
    }

    public Mono<Order> getCache(String id) {
        return null;
    }

    public Mono<Order> getMain(String id) {
        return null;
    }

    public Flux<Item> getItems(String id) {
        return null;
    }
}
