package com.omicronlab.avro;

import java.util.ArrayList;
import java.util.List;
import com.omicronlab.avro.phonetic.Pattern;

public class PhoneticParser {
	
	private static PhoneticParser instance = null;
	private static PhoneticLoader loader = null;
	private static List<Pattern> patterns;
	private boolean initialized = false;
	
	// Prevent initialization
	private PhoneticParser() {
		patterns = new ArrayList<Pattern>();
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public static synchronized PhoneticParser getInstance() {
		if(instance == null) {
			instance = new PhoneticParser();
		}
		return instance;
	}
	
	public void setLoader(PhoneticLoader loader) {
		PhoneticParser.loader = loader;
	}
	
	public void init() throws Exception {
		if(loader == null) {
			new Exception("No PhoneticLoader loader available");
		}
		patterns = loader.getPatterns();
		initialized = true;
	}
	
	public String parse(String input) throws Exception {
		if(initialized == false) {
			this.init();
		}
		String output = "";
		for(int cur = input.length()-1; cur>=0; --cur) {
			int end = cur + 1, start = cur;
			boolean matched = false;
			for(Pattern pattern: patterns) {
				start = end - pattern.getFind().length();
				if(start >= 0) {
					if(input.substring(start, end).equals(pattern.getFind())) {
						output = pattern.getReplace() + output;
						cur = start;
						matched = true;
						break;
					}
				}
			}
			
			if(!matched) {
				output = input.charAt(cur) + output;
			}
		}
		return output;
	}
	
}