package com.yuankui.java.test.javademo.bitmap;

import org.roaringbitmap.RoaringBitmap;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

public class BitMapTest {
    public static void main(String[] args) throws IOException {
        RoaringBitmap rr = RoaringBitmap.bitmapOf();

        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            rr.add(random.nextInt());
        }

        System.out.println("rr = " + rr);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);

        rr.serialize(dos);
        dos.close();
        bos.close();

        byte[] bytes = bos.toByteArray();

        System.out.println("bytes = " + bytes.length);


        long count = StreamSupport.stream(Spliterators
                .spliteratorUnknownSize(rr.iterator(), 0), false)
                .count();

        System.out.println("count = " + count);
    }
}
