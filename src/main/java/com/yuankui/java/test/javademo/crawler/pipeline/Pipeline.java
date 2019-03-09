package com.yuankui.java.test.javademo.crawler.pipeline;

import com.yuankui.java.test.javademo.crawler.pipeline.obj.PipelineDO;
import com.yuankui.java.test.javademo.crawler.pipeline.obj.PluginDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Pipeline<T> {
    @Autowired
    private PluginFactory pluginFactory;

    private Input<T, ?> input;
    private List<Filter<T, ?>> filters;
    private Output<T, ?> output;
    
    public void init(String yaml) {
        PipelineDO pipelineDO = new Yaml().loadAs(yaml, PipelineDO.class);

        PluginDO outputDO = pipelineDO.getOutput();
        input = pluginFactory.create(pipelineDO.getInput().getType(), pipelineDO.getInput().getConfig(), Input.class);
        filters = pipelineDO.getFilter()
                .stream()
                .map(f -> pluginFactory.create(f.getType(), f.getConfig(), Filter.class))
                .collect(Collectors.toList());
        output = pluginFactory.create(outputDO.getType(), outputDO.getConfig(), Output.class);
    }
    
    public void run() {
        Dataset<T> items = input.getItems();
        for (Filter<T, ?> filter : this.filters) {
            items = items.flatMap(item -> filter.filter(item));
        }
        items.forEach(output::output);
    }
}
