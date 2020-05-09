package com.yuankui.java.test.javademo.rxjava;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import okhttp3.*;
import org.junit.Test;

import java.io.IOException;

public class Callback2Flowable {
    OkHttpClient client = new OkHttpClient();

    Flowable<String> get(String url) {
        return Flowable.create(emitter -> {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    emitter.onError(e);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    emitter.onNext(response.body().string());
                    emitter.onComplete();
                }
            });
        }, BackpressureStrategy.BUFFER);
    }
    
    @Test
    public void test() {
        get("https://www.v2ex.com/api/topics/hot.json")
                .flatMapIterable(text -> {
                    return JSON.parseArray(text);
                })
                .map(json -> {
                    JSONObject object = (JSONObject) json;
                    return object.get("title");
                })
                .blockingSubscribe(title -> {
                    System.out.println("title = " + title);
                });
    }
    
}
