package com.yuankui.java.test.javademo.moditor;

import com.yuankui.java.test.javademo.moditor.factory.Model;
import com.yuankui.java.test.javademo.moditor.factory.ModelObject;
import groovy.lang.Closure;
import groovy.lang.GroovyObjectSupport;

import java.util.Map;

public class ModelFactory extends GroovyObjectSupport {
    private Map<String, Model> modelMap;
    private Model root;

    public ModelObject object(String name, Closure closure) {
        ModelObject modelObject = new ModelObject();
        closure.setDelegate(modelObject);
        
        modelMap.put(name, modelObject);
        return modelObject;
    }

    public void root(String modelName) {
        root = modelMap.get(modelName);
    }

}
