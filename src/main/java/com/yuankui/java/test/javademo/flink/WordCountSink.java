package com.yuankui.java.test.javademo.flink;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

public class WordCountSink implements SinkFunction<Tuple2<String,Integer>> {

    private static final long serialVersionUID = 1L;

    @Override
    public void invoke(Tuple2<String, Integer> value, Context context) throws Exception {
        System.out.println("{ Word: \""+ value.f0 + "\", Cnt:" + value.f1 +"}");
    }
}

