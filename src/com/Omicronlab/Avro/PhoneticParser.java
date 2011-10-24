package com.Omicronlab.Avro;

public class PhoneticParser {
	
	private static PhoneticParser instance = null;
	private static PhoneticLoader loader = null;
	private boolean initialized = false;
	
	// Prevent initialization
	private PhoneticParser() {
		
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
		initialized = true;
	}
	
	public String parse(String input) throws Exception {
		if(initialized == false) {
			this.init();
		}
		String output = input;
		return output;
	}
	
}