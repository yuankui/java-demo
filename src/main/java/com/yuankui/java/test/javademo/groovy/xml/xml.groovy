package com.yuankui.java.test.javademo.groovy.xml

import com.yuankui.java.test.javademo.groovy.xml.Xml

def xml = new Xml()

xml = xml.children() {
    child([name: "yuankui1"]) {
        name([age: 12])
    }
    child([name: "yuankui2"])
    child([name: "yuankui3"])
}

println(xml.toXml())

