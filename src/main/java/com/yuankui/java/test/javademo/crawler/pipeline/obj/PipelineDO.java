package com.yuankui.java.test.javademo.crawler.pipeline.obj;

import lombok.Data;

import java.util.List;

@Data
public class PipelineDO {
    private PluginDO input;
    private List<PluginDO> filter;
    private List<PluginDO> output;
}
