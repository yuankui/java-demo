package com.yuankui.java.test.javademo.moditor.factory;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
public class ModelSelect extends Model {

    @Data
    @AllArgsConstructor
    private class Option {
        private String value;
        private String title;
        private Model model;
    }

    private List<Option> options = new ArrayList<>();

    public ModelSelect option(String value, String title, Model model) {
        this.options.add(new Option(value, title, model));
        return this;
    }

    @Override
    public Object config() {
        return this.options
                .stream()
                .map(o -> {
                    JSONObject object = new JSONObject();
                    object.put("value", o.getValue());
                    object.put("title", o.getTitle());
                    object.put("config", o.getModel().toJSON());
                    return object;
                })
                .collect(Collectors.toList());
    }

    @Override
    public String type() {
        return "select";
    }
}
