package com.yuankui.java.test.javademo.generic.notok;

import java.lang.reflect.Type;

public class TargetClass extends MiddleClass<String, Integer> {
    public static void main(String[] args) {
        Type[] interfaces = TargetClass.class.getGenericInterfaces();
        Type superclass = TargetClass.class.getGenericSuperclass();

        Type[] types = superclass.getClass().getGenericInterfaces();
        Type genericSuperclass = ((Class)superclass).getGenericSuperclass();
        System.out.println("superclass = " + superclass);
    }
}
