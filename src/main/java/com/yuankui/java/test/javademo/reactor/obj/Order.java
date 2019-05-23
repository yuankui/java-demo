package com.yuankui.java.test.javademo.reactor.obj;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private String id;
    private List<Item> items;
}
