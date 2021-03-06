package com.yuankui.java.test.javademo.crawler;

import com.alibaba.fastjson.util.IOUtils;
import com.yuankui.java.test.javademo.crawler.pipeline.Pipeline;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Queue;

@Component
public class Crawler {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CrawlerConfig.class);
        Crawler crawler = context.getBean(Crawler.class);
        crawler.start("https://www.v2ex.com/");
    }

    @Autowired
    private Queue<Context> queue;
    
    @Autowired
    private ObjectFactory<Pipeline<Context>> pipelineObjectFactory;
    
    public void start(String start) {
        Context context = new Context();
        context.setUrl(start);
        context.setDeep(0);
        queue.add(context);
        
        Pipeline<Context> pipeline = pipelineObjectFactory.getObject();
        InputStream stream = Crawler.class.getClassLoader().getResourceAsStream("crawler/crawler.yml");
        String yaml = IOUtils.readAll(new InputStreamReader(stream));
        pipeline.init(yaml);
        pipeline.run();
        System.out.println("pipeline = " + pipeline);
    }
}
