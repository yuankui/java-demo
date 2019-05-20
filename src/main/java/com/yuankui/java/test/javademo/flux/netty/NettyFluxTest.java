package com.yuankui.java.test.javademo.flux.netty;

import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

public class NettyFluxTest {
    public static void main(String[] args) {
        DisposableServer server =
                HttpServer.create()
                        .handle((request, response) -> response.sendString(Mono.just("hello")))
                        .port(8999)
                        .bindNow();

        server.onDispose()
                .block();
    }
}
