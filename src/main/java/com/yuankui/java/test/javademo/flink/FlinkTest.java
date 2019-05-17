package com.yuankui.java.test.javademo.flink;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.windowing.time.Time;

public class FlinkTest {
    public static void main(String[] args) {
        DataStream<String> dataStream = null;

        dataStream.timeWindowAll(Time.minutes(1));
        dataStream.countWindowAll(4);
    }
}
