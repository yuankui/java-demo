package com.yuankui.java.test.javademo.groovy.xml

def xml = new Xml()

xml = xml.children() {
    child([name: "yuankui1"]) {
        name([age: 12])
    }
    child([name: "yuankui2"]) {
        $str("hello kitty")
    }
    child([name: "yuankui3"])
}

println(xml.toXml())

