package com.yuankui.java.test.javademo.crawler;

import lombok.Data;

import java.io.Serializable;

@Data
public class Context implements Serializable, Cloneable {
    private static final long serialVersionUID = -8713105296801169157L;
    private int deep;
    private int parentTotal;
    private int seq;
    private String url;
    private String referer;
    private String content;

    @Override
    public Context clone() {
        try {
            return (Context) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
