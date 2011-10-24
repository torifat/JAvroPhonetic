package com.omicronlab.avro.phonetic;

import java.util.List;
import java.util.ArrayList;

public class Pattern {
	
	private String find;
	private String replace;
	private List<Rule> rules;
	
	public Pattern() {
		rules = new ArrayList<Rule>();
	}
	
	public String getFind() {
		return find;
	}
	
	public void setFind(String find) {
		this.find = find;
	}
	
	public String getReplace() {
		return replace;
	}
	
	public void setReplace(String replace) {
		this.replace = replace;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void addRule(Rule rule) {
		rules.add(rule);
	}
	
}
