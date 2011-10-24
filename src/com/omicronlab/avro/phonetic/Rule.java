package com.omicronlab.avro.phonetic;

public class Rule {
	
	private String prefix;
	private String prefixClass;
	private String replace;
	
	public Rule(){
		
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getPrefixClass() {
		return prefixClass;
	}

	public void setPrefixClass(String prefixClass) {
		this.prefixClass = prefixClass;
	}

	public String getReplace() {
		return replace;
	}

	public void setReplace(String replace) {
		this.replace = replace;
	}
	
}
