package com.omicronlab.avro;

import java.util.ArrayList;
import java.util.List;
import com.omicronlab.avro.phonetic.*;

public class PhoneticParser {
	
	private static PhoneticParser instance = null;
	private static PhoneticLoader loader = null;
	private static List<Pattern> patterns;
	private static String vowels = "";
	private static String consonants = "";
	private static String punctuations = "";
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
		Data data = loader.getData();
		patterns = data.getPatterns();
		vowels = data.getVowels();
		consonants = data.getConsonats();
		punctuations = data.getPunctuations();
		initialized = true;
	}
	
	public String parse(String input) throws Exception {
		if(initialized == false) {
			this.init();
		}
		String output = "";
		for(int cur = input.length()-1; cur>=0; --cur) {
			int end = cur + 1, start = cur, prev;
			boolean matched = false;
			for(Pattern pattern: patterns) {
				start = end - pattern.getFind().length();
				if(start >= 0 && input.substring(start, end).equals(pattern.getFind())) {
					prev = start -1;
					
					for(Rule rule: pattern.getRules()) {
						boolean replace = false;
						// Beginning
						if(rule.getPrefixClass().equals("none")) {
							if(prev < 0 || isPunctuation(input.charAt(prev))) {
								replace = true;
							}
						}
						// Vowel
						else if(rule.getPrefixClass().equals("vowel")) {
							if(prev < 0 || isVowel(input.charAt(prev))) {
								replace = true;
							}
						}
						// Custom
						else if(rule.getPrefixClass().equals("custom")) {
							int prevStart = start - rule.getPrefix().length();
							if(prevStart >= 0 && input.substring(prevStart, start).equals(rule.getPrefix())) {
								replace = true;
							}
						}
						
						if(replace) {
							output = rule.getReplace() + output;
							cur = start;
							matched = true;
							break;
						}
						
					}
					if(matched == true) break;
					
					// Default
					output = pattern.getReplace() + output;
					cur = start;
					matched = true;
					break;
				}
			}
			
			if(!matched) {
				output = input.charAt(cur) + output;
			}
		}
		return output;
	}
	
	private boolean isVowel(char c) {
		return (vowels.indexOf(c) >= 0);
	}
	
	private boolean isConsonant(char c) {
		return (consonants.indexOf(c) >= 0);
	}
	
	private boolean isPunctuation(char c) {
		return (punctuations.indexOf(c) >= 0);
	}
	
}