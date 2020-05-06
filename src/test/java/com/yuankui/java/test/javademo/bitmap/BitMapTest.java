package com.yuankui.java.test.javademo.bitmap;

import org.junit.Test;
import org.roaringbitmap.longlong.Roaring64NavigableMap;

public class BitMapTest {
    
    @Test
    public void test() {

        final Roaring64NavigableMap allOne = new Roaring64NavigableMap();

        for (int i = 0; i < 1000; i++) {
            allOne.add(i);
        }

        Roaring64NavigableMap one = new Roaring64NavigableMap();
        
        
        one.add(11);
        one.add(12);
    }
}