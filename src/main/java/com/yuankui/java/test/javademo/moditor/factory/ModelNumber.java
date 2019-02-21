package com.yuankui.java.test.javademo.moditor.factory;

import lombok.ToString;

@ToString
public class ModelNumber extends Model {
    @Override
    public String type() {
        return "number";
    }
}
