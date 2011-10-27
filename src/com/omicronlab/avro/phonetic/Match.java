package com.omicronlab.avro.phonetic;

public class Match {
	private String type;
	private String scope;
	private String value;
	private boolean negative;
	
	public Match() {
		negative = false;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		if(scope.charAt(0) == '!') {
			this.negative = true;
			scope = scope.substring(1);
		}
		this.scope = scope;
	}

	public boolean isNegative() {
		return negative;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
