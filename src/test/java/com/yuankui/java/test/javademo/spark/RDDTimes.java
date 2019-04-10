package com.yuankui.java.test.javademo.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.rdd.RDD;

import java.util.List;

public class RDDTimes {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local");
        sparkConf.setAppName("localApp");
        SparkContext context = new SparkContext(sparkConf);

        RDD<Object> range = context.range(1, 10, 1, 2);

        JavaRDD<String> withPre = range.toJavaRDD()
                .map(v1 -> {
                    System.out.println("println:" + v1);
                    return "pre:" + v1.toString();
                });
        
        withPre.foreach(v -> System.out.println("v = " + v));

        List<String> collect = withPre.collect();

        System.out.println("collect = " + collect);
    }
}
