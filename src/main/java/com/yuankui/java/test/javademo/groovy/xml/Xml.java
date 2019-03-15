package com.yuankui.java.test.javademo.groovy.xml;

import groovy.lang.Closure;
import groovy.lang.GroovyObjectSupport;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Xml extends GroovyObjectSupport {
    private Map<String, Object> _props = new HashMap<>();
    private List<Xml> _children = new ArrayList<>();
    private String _name;
    private Xml _parent;
    
    Xml build(String name, Map<String, Object> props, Closure closure) {
        Xml xml = new Xml();
        xml._name = name;
        xml._parent = this;
        xml._props = props;
        if(closure != null) {
            closure.setDelegate(xml);
            closure.call();
        }
        this.addChild(xml);
        return xml;
    }

    @Override
    public Object invokeMethod(String name, Object arg) {
        assert arg instanceof Object[];
        Object[] args = (Object[]) arg;
        Xml xml = null;
        if (args.length == 1) {
            if (args[0] instanceof Map) {
                xml = build(name, (Map) args[0], null);
            } else if (args[0] instanceof Closure) {
                xml = build(name, null, (Closure) args[0]);
            } else {
                throw new RuntimeException("invalid param type:" + args[0].getClass());
            }
        } else if (args.length == 2) {
            if (args[0] instanceof Map && args[1] instanceof Closure) {
                xml = build(name, (Map) args[0], (Closure) args[1]);
            } else {
                throw new RuntimeException("invalid param type:" + args[0].getClass() + ";" + args[1].getClass());
            }
        }
        
        return xml;
    }
    
    private void addChild(Xml xml) {
        this._children.add(xml);
    }

    private Element toDoc(Document document) {
        Element element = document.createElement(_name);
        if (_props != null) {
            _props.forEach((k,v) -> {
                element.setAttribute(k, String.valueOf(v));
            });
        }
        return element;
    }
    public String toXml() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = toDoc(document);
        document.appendChild(root);
        if (_children != null) {
            _children.stream()
                    .map(c -> c.toDoc(document))
                    .forEach(root::appendChild);
        }

        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();
        StringWriter s = new StringWriter();
        tf.transform(new DOMSource(document), new StreamResult(s));

        return s.toString();
    }
}
