/*
	=============================================================================
	*****************************************************************************
	The contents of this file are subject to the Mozilla Public License
	Version 1.1 (the "License"); you may not use this file except in
	compliance with the License. You may obtain a copy of the License at
	http://www.mozilla.org/MPL/

	Software distributed under the License is distributed on an "AS IS"
	basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
	License for the specific language governing rights and limitations
	under the License.

	The Original Code is JAvroPhonetic

	The Initial Developer of the Original Code is
	Rifat Nabi <to.rifat@gmail.com>

	Copyright (C) OmicronLab (http://www.omicronlab.com). All Rights Reserved.


	Contributor(s): ______________________________________.

	*****************************************************************************
	=============================================================================
*/

package com.omicronlab.avro;

import java.io.FileReader;
import java.io.IOException;
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
    	digester.addBeanPropertySetter("data/classes/vowel", "vowel");
        digester.addBeanPropertySetter("data/classes/consonant", "consonant");
        digester.addBeanPropertySetter("data/classes/punctuation", "punctuation");
        digester.addBeanPropertySetter("data/classes/casesensitive", "casesensitive");
        
    	digester.addObjectCreate("data/patterns/pattern", Pattern.class);
        digester.addBeanPropertySetter("data/patterns/pattern/find", "find");
        digester.addBeanPropertySetter("data/patterns/pattern/replace", "replace");
        
        digester.addObjectCreate("data/patterns/pattern/rules/rule", Rule.class);
        digester.addBeanPropertySetter("data/patterns/pattern/rules/rule/replace", "replace");
        
        digester.addObjectCreate("data/patterns/pattern/rules/rule/find/match", Match.class);
        digester.addBeanPropertySetter("data/patterns/pattern/rules/rule/find/match", "value");
        digester.addSetProperties("data/patterns/pattern/rules/rule/find/match", "type", "type");
        digester.addSetProperties("data/patterns/pattern/rules/rule/find/match", "scope", "scope");
        
        digester.addSetNext("data/patterns/pattern/rules/rule/find/match", "addMatch");
        
        digester.addSetNext("data/patterns/pattern/rules/rule", "addRule");
        
        digester.addSetNext("data/patterns/pattern", "addPattern");
        
        Data data = (Data) digester.parse(new InputSource(new FileReader(path)));
		return data;
    }
}
