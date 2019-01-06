package com.yuankui.java.test.javademo.customaop.aop;

import com.alibaba.fastjson.JSON;
import com.yuankui.java.test.javademo.customaop.Fetcher;

public class ResultFetchWrapper implements Fetcher {
    private Fetcher fetcher;

    public ResultFetchWrapper(Fetcher fetcher) {
        this.fetcher = fetcher;
    }

    @Override
    public Object fetch(String param) {
        Object fetch = fetcher.fetch(param);
        Result<Object> result = new Result<>("success", fetch);
        return JSON.toJSONString(result);
    }
}
