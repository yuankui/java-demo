package com.yuankui.java.test.javademo.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

public class EngineTest {
    public static void main(String[] args) {
        Script script = new GroovyShell().parse("static def a() {\n" +
                "    return new Date().toLocaleString()\n" +
                "}");

        Binding binding = new Binding();
        script.setBinding(binding);

        Object ret = script.run();

        System.out.println("ret = " + ret);
    }
}
