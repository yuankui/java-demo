package com.yuankui.java.test.javademo.assertJ;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

public class AssertJTest {
    @Test
    public void test() {

        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),
                2000000,
                0.01);

        int count = 0;

        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 20000000; i++) {
//            bitmap.add(random.nextInt(Integer.MAX_VALUE));
            if (!bloomFilter.test(i)) {
                count += 1;
                bloomFilter.put(i);
            }
        }
        System.out.println(System.currentTimeMillis());


    }
}
