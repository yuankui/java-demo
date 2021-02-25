package com.yuankui.java.test.javademo.hamcrest;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.Test;

public class HamcrestTest {
    @Test
    public void test() {
        assertThat("hello", startsWith("he"));
    }
}
