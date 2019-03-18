package com.yuankui.java.test.javademo.groovy

def a1 = {
    def name = "hello"
    def a2 = {
        println("a2: $name")
        def a3 = {
            println("a3: $name")
        }
        a3()
    }
    a2()
}

a1()