package com.yuankui.java.test.javademo.scalascript;

import avro.shaded.com.google.common.base.Stopwatch;
import scala.Function1;
import scala.tools.nsc.interpreter.IMain;
import scala.tools.nsc.settings.MutableSettings;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;

public class ScalaScriptTest {
    public static void main(String[] args) throws ScriptException, IOException, ClassNotFoundException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("scala");

        ((MutableSettings.BooleanSetting)(((IMain)engine)
                .settings().usejavacp()))
                .value_$eq(true);

        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //language=Scala
        String testScript = "import com.alibaba.fastjson.JSON\n" +
                "\n" +
                "(a: String) => JSON.parseObject(a)";
        
        
        Function1 ret = (Function1) engine.eval(testScript);
        System.out.println("stopwatch.elapsedMillis() = " + stopwatch.elapsedMillis());

        Object hello = ret.apply("{\"name\": 2}");

        System.out.println("hello = " + hello);
        System.out.println("stopwatch = " + stopwatch.elapsedMillis());

    }
}
