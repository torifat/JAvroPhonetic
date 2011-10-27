package com.omicronlab.avro;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.omicronlab.avro.phonetic.*;

public class PhoneticParser {
	
	private static PhoneticParser instance = null;
	private static PhoneticLoader loader = null;
	private static List<Pattern> patterns;
	private static String vowel = "";
	private static String consonant = "";
	private static String punctuation = "";
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
	
	public synchronized void setLoader(PhoneticLoader loader) {
		PhoneticParser.loader = loader;
	}
	
	public synchronized void init() throws Exception {
		if(loader == null) {
			new Exception("No PhoneticLoader loader available");
		}
		Data data = loader.getData();
		patterns = data.getPatterns();
		vowel = data.getVowel();
		consonant = data.getConsonant();
		punctuation = data.getPunctuation();
		initialized = true;
	}
	
	public String parse(String input) throws Exception {
		
		// Logger logger = Logger.getAnonymousLogger();
		
		if(initialized == false) {
			this.init();
		}
		String output = "";
		for(int cur = 0; cur < input.length(); ++cur) {
			int start = cur, end = cur + 1, next = end + 1, prev = start - 1;
			boolean matched = false;
			for(Pattern pattern: patterns) {
				end = cur + pattern.getFind().length();
				if(end <= input.length() && input.substring(start, end).equals(pattern.getFind())) {
					prev = start - 1;
					next = end + 1;
					for(Rule rule: pattern.getRules()) {
						boolean replace = true;
						
						int chk = -1;
						
						for(Match match: rule.getMatches()) {
							if(match.getType().equals("suffix")) {
								chk = next;
							} 
							// Prefix
							else {
								chk = prev;
							}
							
							// Beginning
							if(match.getScope().equals("punctuation")) {
								if(
										! (
											(chk < 0 && match.getType().equals("prefix")) || 
											(chk >= input.length() && match.getType().equals("suffix")) || 
											isPunctuation(input.charAt(chk), match.isNegative())
										)
								) {
									replace = false;
									break;
								}
							}
							// Vowel
							else if(match.getScope().equals("vowel")) {
								if(
										! (
											(
												(chk >= 0 && match.getType().equals("prefix")) || 
												(chk < input.length() && match.getType().equals("suffix"))
											) && 
											isVowel(input.charAt(chk), match.isNegative())
										)
								) {
									replace = false;
									break;
								}
							}
							// Consonant
							else if(match.getScope().equals("consonant")) {
								if(
										! (
												(
													(chk >= 0 && match.getType().equals("prefix")) || 
													(chk < input.length() && match.getType().equals("suffix"))
												) && 
												isConsonant(input.charAt(chk), match.isNegative())
											)
								) {
									replace = false;
									break;
								}
							}
							// Exact
							else if(match.getScope().equals("exact")) {
								int s, e;
								if(match.getType().equals("suffix")) {
									s = end;
									e = end + match.getValue().length() - 1;
								} 
								// Prefix
								else {
									s = start - match.getValue().length();
									e = start;
								}
								if(!isExact(match.getValue(), input, s, e, match.isNegative())) {
									replace = false;
									break;
								}
							}
						}
						
						if(replace) {
							output += rule.getReplace();
							cur = end - 1;
							matched = true;
							break;
						}
						
					}

					if(matched == true) break;
					
					// Default
					output += pattern.getReplace();
					cur = end - 1;
					matched = true;
					break;
				}
			}
			
			if(!matched) {
				output += input.charAt(cur);
			}
			// System.out.printf("cur: %s, start: %s, end: %s, prev: %s\n", cur, start, end, prev);
		}
		return output;
	}
	
	private boolean isVowel(char c, boolean not) {
		return ((vowel.indexOf(c) >= 0) ^ not);
	}
	
	private boolean isConsonant(char c, boolean not) {
		return ((consonant.indexOf(c) >= 0) ^ not);
	}
	
	private boolean isPunctuation(char c, boolean not) {
		return ((punctuation.indexOf(c) >= 0) ^ not);
	}
	
	private boolean isExact(String needle, String heystack, int start, int end, boolean not) {
		return ((start >= 0 && end < heystack.length() && heystack.substring(start, end).equals(needle)) ^ not);
	}
	
}