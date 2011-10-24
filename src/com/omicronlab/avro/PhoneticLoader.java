package com.omicronlab.avro;

import java.util.List;

import com.omicronlab.avro.phonetic.Pattern;

public interface PhoneticLoader {
	public List<Pattern> getPatterns() throws Exception;
}
