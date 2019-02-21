package com.yuankui.java.test.javademo.moditor.factory;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModelObject implements Model {

    // 保序
    private Map<String, Model> fieldMap = new LinkedHashMap<>();
    
    public void field(String fieldName, Model model) {
        fieldMap.put(fieldName, model);
    }
}
