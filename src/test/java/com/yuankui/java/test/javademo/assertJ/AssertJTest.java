package com.yuankui.java.test.javademo.assertJ;

import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import java.util.Arrays;

public class AssertJTest {
    @Test
    public void test() {
        Assertions.assertThat(Arrays.asList(1, 2))
                .size().isGreaterThan(10);

    }
}
