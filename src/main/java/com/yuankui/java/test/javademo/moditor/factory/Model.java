package com.yuankui.java.test.javademo.moditor.factory;

import com.alibaba.fastjson.JSONObject;

public abstract class Model {
    public abstract String type();
    public Object config() {
        return null;
    }
    
    public final Object toJSON() {
        JSONObject object = new JSONObject();
        object.put("type", this.type());
        object.put("config", this.config());
        return object;
    }
}
