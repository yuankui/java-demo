package com.yuankui.java.test.javademo.crawler.pipeline;

import com.yuankui.java.test.javademo.crawler.pipeline.obj.PipelineDO;
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
    private List<Filter> filters;
    private List<Output> outputs;
    
    public void init(String yaml) {
        PipelineDO pipelineDO = new Yaml().loadAs(yaml, PipelineDO.class);

        
        input = pluginFactory.create(pipelineDO.getInput().getType(), pipelineDO.getInput().getConfig(), Input.class);
        filters = pipelineDO.getFilter()
                .stream()
                .map(f -> pluginFactory.create(f.getType(), f.getConfig(), Filter.class))
                .collect(Collectors.toList());
        outputs = pipelineDO.getOutput()
                .stream()
                .map(o -> pluginFactory.create(o.getType(), o.getConfig(), Output.class))
                .collect(Collectors.toList());
    }
    
    public void run() {
        Dataset<T> items = input.getItems();
        
        for (Filter filter : this.filters) {
            items = filter.filter(items);
        }
        items.foreach(item -> outputs.forEach(o -> o.output(item)));
    }
}
