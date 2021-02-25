package com.yuankui.java.test.javademo.assertJ;

import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.junit.Test;

public class AssertJTest {
    @Test
    public void test() {
        Assertions.assertThat(1.1)
                .isCloseTo(1.2, Percentage.withPercentage(10));
    }
}
