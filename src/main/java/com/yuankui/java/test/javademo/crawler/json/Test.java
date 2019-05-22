package com.yuankui.java.test.javademo.crawler.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        IntStream.range(1, 20)
                .mapToObj(n -> "http://adr.meizitu.net/wp-json/wp/v2/posts?page=" + n + "&per_page=100")
                .parallel()
                .peek(System.out::println)
                .map(url -> executorService.submit(() -> {
                    Request request = new Request.Builder().url(url).build();
                    Call call = client.newCall(request);
                    try {
                        return call.execute().body().string();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }))
                .collect(Collectors.toList())
                .stream()
                .map(f -> {
                    try {
                        return f.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .peek(System.out::println)
                .map(str -> JSON.parseArray(str))
                .flatMap(array -> array.stream())
                .map(obj -> (JSONObject)obj)
                .map(obj -> obj.getString("thumb_src"))
                .forEach(System.out::println);
    }
}
