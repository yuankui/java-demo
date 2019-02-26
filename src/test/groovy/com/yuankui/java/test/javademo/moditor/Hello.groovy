package com.yuankui.java.test.javademo.moditor

class Hello extends GroovyObjectSupport {
    @Override
    Object invokeMethod(String name, Object args) {
        print("name:$name, args:$args")
        return name
    }

    static void main(String[] args) {
        def a = new Hello()

        a.sayhello()
    }
}
