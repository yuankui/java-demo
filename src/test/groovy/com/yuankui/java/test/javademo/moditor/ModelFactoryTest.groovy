package com.yuankui.java.test.javademo.moditor


import org.junit.Test

class ModelFactoryTest {
    
    @Test
    void test() {
        def scriptStr = """
in_model = model.object() {
    field 'field', model.string()
    field 'value', model.number()
}

regex_model = model.object() {
    field 'field', model.string()
    field 'value', model.string()
}

action_select = model.select()
    .option("value1", "title1", regex_model)
    .option("value2", "title2", in_model)

model.root model.object() {
    field 'name', model.string()
    field 'age', model.number()
    field 'filter', action_select
}

"""
        def script = new GroovyShell().parse(scriptStr)
        Binding binding = new Binding()
        ModelFactory modelFactory = new ModelFactory()
        binding.setVariable("model", modelFactory)

        
        script.setBinding(binding)
        script.run()

        println "modelFactory = ${modelFactory.json()}"
    }
}