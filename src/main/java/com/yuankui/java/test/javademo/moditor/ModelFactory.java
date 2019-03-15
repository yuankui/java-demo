package com.yuankui.java.test.javademo.moditor;

import com.alibaba.fastjson.JSON;
import com.yuankui.java.test.javademo.moditor.factory.*;
import groovy.lang.Closure;
import groovy.lang.GroovyObjectSupport;
import lombok.Data;

@Data
public class ModelFactory extends GroovyObjectSupport {
    private Model root;

    public ModelObject object(Closure closure) {
        ModelObject modelObject = new ModelObject();
        closure.setDelegate(modelObject);
        closure.run();
        
        return modelObject;
    }

    public ModelString string() {
        return new ModelString();
    }

    public ModelNumber number() {
        return new ModelNumber();
    }
    
    public void root(Model model) {
        root = model;
    }
    
    public ModelSelect select() {
        return new ModelSelect();
    }
    
    public String json() {
        return JSON.toJSONString(root.toJSON());
    }

}
