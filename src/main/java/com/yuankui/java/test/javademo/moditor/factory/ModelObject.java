package com.yuankui.java.test.javademo.moditor.factory;

import com.alibaba.fastjson.JSONObject;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ToString
public class ModelObject extends Model {
    // 保序
    private Map<String, Model> fieldMap = new LinkedHashMap<>();
    
    public void field(String fieldName, Model model) {
        fieldMap.put(fieldName, model);
    }

    @Override
    public Object config() {
        return this.fieldMap.entrySet().stream()
                .map(kv -> {
                    JSONObject object = new JSONObject();
                    object.put("name", kv.getKey());
                    object.put("type", kv.getValue().toJSON());
                    return object;
                })
                .collect(Collectors.toList());
    }

    @Override
    public String type() {
        return "object";
    }
}
