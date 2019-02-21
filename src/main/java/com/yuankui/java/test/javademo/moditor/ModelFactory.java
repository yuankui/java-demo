package com.yuankui.java.test.javademo.moditor;

import com.alibaba.fastjson.JSON;
import com.yuankui.java.test.javademo.moditor.factory.Model;
import com.yuankui.java.test.javademo.moditor.factory.ModelNumber;
import com.yuankui.java.test.javademo.moditor.factory.ModelObject;
import com.yuankui.java.test.javademo.moditor.factory.ModelString;
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
    
    public String json() {
        return JSON.toJSONString(root.toJSON());
    }

}
