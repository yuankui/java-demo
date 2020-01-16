package com.yuankui.java.test.javademo.generic.ok;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class TargetClass implements BaseClass<String> {
    

    public static void main(String[] args) throws NoSuchMethodException {
        Method getData = TargetClass.class.getMethod("getData");
        Type returnType = getData.getGenericReturnType();

        System.out.println("returnType = " + returnType);
    }

    @Override
    public String getData() {
        return null;
    }
}
