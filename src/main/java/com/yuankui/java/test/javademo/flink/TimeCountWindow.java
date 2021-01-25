package com.yuankui.java.test.javademo.flink;

import com.google.common.collect.Lists;
import org.apache.flink.api.common.state.ListState;
import org.apache.flink.api.common.state.ListStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.List;

public class TimeCountWindow<K, T> extends KeyedProcessFunction<K, T, List<T>> {
    private final long windowSize;
    protected long count;
    private ListState<T> state;
    private Class<T> typeClass;
    private boolean isTimerSet = false;

    public TimeCountWindow(long windowSize, long count, Class<T> typeClass) {
        this.windowSize = windowSize;
        this.count = count;
        this.typeClass = typeClass;
    }

    @Override
    public void open(Configuration parameters) {

        TypeInformation<T> typeInformation = TypeInformation.of(typeClass);
        ListStateDescriptor<T> descriptor = new ListStateDescriptor<>("Buffered:" + windowSize, typeInformation);

        this.state = getRuntimeContext().getListState(descriptor);
    }


    @Override
    public void processElement(T value, Context ctx, Collector<List<T>> out) throws Exception {
        state.add(value);
        ArrayList<T> elements = Lists.newArrayList(state.get());

        if (!isTimerSet) {
            ctx.timerService().registerProcessingTimeTimer(System.currentTimeMillis() + windowSize);
            isTimerSet = true;
        }

        // 如果达到一定大小，就进行flush
        if (elements.size() >= this.count) {
            state.clear();
            out.collect(elements);
            ctx.timerService().registerProcessingTimeTimer(System.currentTimeMillis() + windowSize);
        }
    }

    @Override
    public void onTimer(long timestamp, OnTimerContext ctx, Collector<List<T>> out) throws Exception {
        ArrayList<T> elements = Lists.newArrayList(state.get());
        if (elements.size() > 0) {
            out.collect(elements);
            state.clear();
            ctx.timerService().registerProcessingTimeTimer(System.currentTimeMillis() + windowSize);
        }
    }
}
