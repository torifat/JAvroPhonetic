package com.omicronlab.avro;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.digester3.Digester;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import com.omicronlab.avro.phonetic.*;

public class PhoneticXmlLoader implements PhoneticLoader {
	
	private String path = null;
	
	PhoneticXmlLoader(String path) {
		this.path = path;
	}
	
    public Data getData() throws IOException, SAXException {
    	Digester digester = new Digester();
    	digester.setValidating(false);
    	
    	digester.addObjectCreate("data", Data.class);
    	digester.addBeanPropertySetter("data/vowels", "vowels");
        digester.addBeanPropertySetter("data/consonants", "consonants");
        digester.addBeanPropertySetter("data/punctuations", "punctuations");
        
    	// digester.addObjectCreate("data/patterns", ArrayList.class);
        digester.addObjectCreate("data/patterns/pattern", Pattern.class);
        digester.addBeanPropertySetter("data/patterns/pattern/find", "find");
        digester.addBeanPropertySetter("data/patterns/pattern/replace", "replace");
        
        digester.addObjectCreate("data/patterns/pattern/rules/rule", Rule.class);
        digester.addSetProperties("data/patterns/pattern/rules/rule/prefix", "class", "prefixClass");
        digester.addBeanPropertySetter("data/patterns/pattern/rules/rule/prefix", "prefix");
        digester.addBeanPropertySetter("data/patterns/pattern/rules/rule/replace", "replace");
        digester.addSetNext("data/patterns/pattern/rules/rule", "addRule");
        
        digester.addSetNext("data/patterns/pattern", "addPattern");
        
        Data data = (Data) digester.parse(new InputSource(new FileReader(path)));
		return data;
    }
}
