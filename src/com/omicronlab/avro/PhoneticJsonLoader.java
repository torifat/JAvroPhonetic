/*
	=============================================================================
	*****************************************************************************
	The contents of this file are subject to the Mozilla Public License
	Version 1.1 (the "License"); you may not use this file except in
	compliance with the License. You may obtain a copy of the License at
	http://www.mozilla.org/MPL/

	Software distributed under the License is distributed on an "AS IS"
	basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
	License for the specific language governing rights and limitations
	under the License.

	The Original Code is JAvroPhonetic

	The Initial Developer of the Original Code is
	Rifat Nabi <to.rifat@gmail.com>

	Copyright (C) OmicronLab (http://www.omicronlab.com). All Rights Reserved.


	Contributor(s): ______________________________________.

	*****************************************************************************
	=============================================================================
*/

package com.omicronlab.avro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.omicronlab.avro.phonetic.*;

public class PhoneticJsonLoader implements PhoneticLoader {
	
	private URL url = null;
	
	public PhoneticJsonLoader() {
		this.url = Data.class.getResource("phonetic.json");
	}
	
	public PhoneticJsonLoader(String path) throws MalformedURLException {
		this.url = new URL(path);
	}
	
    public Data getData() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
    	Gson gson = new Gson();
    	Data data = (Data) gson.fromJson(new FileReader(this.url.getFile()), Data.class);
		return data;
    }
}
