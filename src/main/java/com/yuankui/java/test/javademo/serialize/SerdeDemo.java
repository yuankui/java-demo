package com.yuankui.java.test.javademo.serialize;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Map;

public class SerdeDemo {
    public static void main(String[] args) {
        DataOutputStream dataOutputStream = null;

        Map<String, Object> kvs = null;
        Map<String, Integer> labelIdMap = null;

        kvs.forEach((k, v) -> {
            try {
                dataOutputStream.writeInt(labelIdMap.get(k));
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        
    }
}
