package com.yuankui.java.test.javademo.flink;

import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.List;

public class FlinkTest {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime);

        
        DataStream<Integer> source = env.addSource(new WordCountSource()).name("SteveJobs-Word");

        source.keyBy(s -> {
            return 1;
        })
                .process(new TimeCountWindow<>(1500, 10, Integer.class))
                .addSink(new SinkFunction<List<Integer>>() {
                    @Override
                    public void invoke(List<Integer> value, Context context) throws Exception {
                        System.out.println("value = " + value);
                    }
                });

        env.execute("Word Count");
    }
}
