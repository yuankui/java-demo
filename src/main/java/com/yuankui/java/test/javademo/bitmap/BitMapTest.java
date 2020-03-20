package com.yuankui.java.test.javademo.bitmap;

import org.roaringbitmap.RoaringBitmap;

import java.util.Random;

public class BitMapTest {
    public static void main(String[] args) {
        RoaringBitmap rr = RoaringBitmap.bitmapOf();

        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            rr.add(random.nextInt(1000000));
        }
        System.out.println("rr.serializedSizeInBytes() = " + rr.serializedSizeInBytes());


        RoaringBitmap rr2 = new RoaringBitmap();
        for (Integer integer : rr) {
            rr2.add(integer + 100000000);
        }

        System.out.println("rr2.serializedSizeInBytes() = " + rr2.serializedSizeInBytes());
        
        RoaringBitmap rr3 = new RoaringBitmap(rr.toMutableRoaringBitmap());
        rr3.or(rr2);

        System.out.println("rr3.serializedSizeInBytes() = " + rr3.serializedSizeInBytes());
    }
}
