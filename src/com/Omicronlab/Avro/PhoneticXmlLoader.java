package com.Omicronlab.Avro;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class PhoneticXmlLoader implements PhoneticLoader {
	
	private Document domTree = null;
	
	PhoneticXmlLoader(String xml) throws Exception {
		InputSource source = new InputSource(new StringReader(xml));
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
        	this.domTree = dbf.newDocumentBuilder().parse(source);
        } catch (SAXException e) {
        	throw new SAXException("Parsing error when building Document object from xml data.");
        } catch (IOException e) {
        	throw new IOException("Reading error when building Document object from xml data.");
        } catch (ParserConfigurationException e) {
        	throw new ParserConfigurationException("Parsing error when building Document object from xml data.");
        }
	}
	
    public List<?> load() {
    	List<?> rules = new ArrayList<String>();
    	return rules;
    }
}
