package com.yuankui.java.test.javademo.reactor.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import reactor.core.publisher.Flux;
import reactor.netty.http.client.HttpClient;

public class HttpTest {
    public static void main(String[] args) {
        Flux<JSONObject> objs = HttpClient.create()
                .baseUrl("")
                .get()
                .responseContent()
                .asString()
                .doOnError(e -> {})
                .map(JSON::parseObject);

    }
}
