package com.omicronlab.avro.phonetic;

import java.util.ArrayList;
import java.util.List;

public class Data {
	private List<Pattern> patterns;
	private String vowels = "";
	private String consonats = "";
	private String punctuations = "";
	
	public Data() {
		this.patterns = new ArrayList<Pattern>();
	}
	
	public List<Pattern> getPatterns() {
		return patterns;
	}
	
	public void addPattern(Pattern pattern) {
		this.patterns.add(pattern);
	}
	
	public String getVowels() {
		return vowels;
	}

	public void setVowels(String vowels) {
		this.vowels = vowels;
	}

	public String getConsonats() {
		return consonats;
	}

	public void setConsonats(String consonats) {
		this.consonats = consonats;
	}

	public String getPunctuations() {
		return punctuations;
	}

	public void setPunctuations(String punctuations) {
		this.punctuations = punctuations;
	}

}
