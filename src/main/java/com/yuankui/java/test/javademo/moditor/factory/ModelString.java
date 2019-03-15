package com.yuankui.java.test.javademo.moditor.factory;

import lombok.ToString;

@ToString
public class ModelString extends Model {
    @Override
    public String type() {
        return "string";
    }
}
