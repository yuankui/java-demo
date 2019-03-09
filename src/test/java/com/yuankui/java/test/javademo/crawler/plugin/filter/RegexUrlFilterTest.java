package com.yuankui.java.test.javademo.crawler.plugin.filter;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class RegexUrlFilterTest {

    @Test
    public void filter() {
        Pattern pattern = Pattern.compile("/member/\\w+");
        Matcher matcher = pattern.matcher("https://www.v2ex.com/member/ganhuoer");
        boolean b = matcher.find();
        System.out.println("b = " + b);


    }
}