package com.omicronlab.avro;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
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
	
    public List<Pattern> getPatterns() throws IOException, SAXException {
    	Digester digester = new Digester();
    	digester.setValidating(false);
        digester.addObjectCreate("patterns", ArrayList.class);
        digester.addObjectCreate("patterns/pattern", Pattern.class);
        digester.addBeanPropertySetter("patterns/pattern/find", "find");
        digester.addBeanPropertySetter("patterns/pattern/replace", "replace");
        
        digester.addObjectCreate("patterns/pattern/rules/rule", Rule.class);
        digester.addSetProperties("patterns/pattern/rules/rule/prefix", "class", "prefixClass");
        digester.addBeanPropertySetter("patterns/pattern/rules/rule/prefix", "prefix");
        digester.addBeanPropertySetter("patterns/pattern/rules/rule/replace", "replace");
        digester.addSetNext("patterns/pattern/rules/rule", "addRule");
        
        digester.addSetNext("patterns/pattern", "add");
        
        @SuppressWarnings("unchecked")
        List<Pattern> patterns = (List<Pattern>) digester.parse(new InputSource(new FileReader(path)));
		return patterns;
    }
}
