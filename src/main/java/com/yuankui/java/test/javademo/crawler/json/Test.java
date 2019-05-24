package com.yuankui.java.test.javademo.crawler.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import reactor.core.publisher.Flux;
import reactor.netty.http.client.HttpClient;


public class Test {
    public static void main(String[] args) {

        Flux.range(1, 20)
                .map(n -> "http://adr.meizitu.net/wp-json/wp/v2/posts?page=" + n + "&per_page=100")
                .flatMap(url -> HttpClient.create()
                        .baseUrl(url)
                        .get()
                        .responseContent()
                        .aggregate()
                        .asString()
                )
                .map(JSON::parseArray)
                .flatMap(Flux::fromIterable)
                .map(obj -> (JSONObject) obj)
                .map(obj -> obj.getString("thumb_src"))
                .doOnError(e -> {
                })
                .subscribe(System.out::println);
    }
}
