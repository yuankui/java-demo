package com.yuankui.java.test.javademo.javap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class Caller {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();


        MyLoader myLoader = new MyLoader("/Users/yuankui/work/kotlintest/out/production/kotlintest");

        String name = "hello/Foo".replace("/", ".");
        Thread.currentThread().setContextClassLoader(myLoader);

        Class<?> callee = myLoader.loadClass(name);

        Object inst = callee.newInstance();

        Method test = inst.getClass().getDeclaredMethod("run");

        Object ret = test.invoke(inst);
        System.out.println("ret = " + ret);


    }
}
