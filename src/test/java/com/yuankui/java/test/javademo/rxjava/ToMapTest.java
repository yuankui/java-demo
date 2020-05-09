package com.yuankui.java.test.javademo.rxjava;

import com.alibaba.fastjson.JSON;
import io.reactivex.Flowable;
import org.junit.Test;

public class ToMapTest {

    @Test
    public void toMap() {
        Flowable.range(0, 10)
                .toMap(Object::toString, i->i * 100)
                .subscribe(map -> {
                    String json = JSON.toJSONString(map, true);
                    System.out.println("json = " + json);
                });
    }
}

