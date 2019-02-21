package com.yuankui.java.test.javademo.moditor


import org.junit.Test

class ModelFactoryTest {
    
    @Test
    void test() {
        def scriptStr = """

regex_model = model.object() {
    field 'field', model.string()
    field 'value', model.string()
}
model.root model.object() {
    field 'name', model.string()
    field 'age', model.number()
    field 'filter', regex_model
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