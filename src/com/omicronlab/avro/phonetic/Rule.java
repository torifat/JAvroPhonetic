package com.omicronlab.avro.phonetic;

import java.util.ArrayList;
import java.util.List;

public class Rule {
	
	private List<Match> matches;
	private String replace;
	
	public Rule(){
		this.matches = new ArrayList<Match>();
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void addMatch(Match match) {
		this.matches.add(match);
	}

	public String getReplace() {
		return replace;
	}

	public void setReplace(String replace) {
		this.replace = replace;
	}
}
