package com.Omicronlab.Avro;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;


// http://stackoverflow.com/questions/373833/best-xml-parser-for-java/5665730#5665730

public class PhoneticXmlLoader implements PhoneticLoader {
	
	private Document doc = null;
	
	PhoneticXmlLoader(String file) throws Exception {
		File xml = new File(file);
		SAXReader reader = new SAXReader();
		this.doc = reader.read(xml);
	}
	
    public List<?> load() {
    	List<?> rules = new ArrayList<String>();
    	return rules;
    }
}
