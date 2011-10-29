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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AvroTest {
	
	private PhoneticParser avro;
	
	@Before
	public void beforeTest() {
		try {
			 avro = PhoneticParser.getInstance();
			 avro.setLoader( new PhoneticXmlLoader() );
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something very unholy has just happened :|");
		}
	}

	@Test
	public void testAmiBanglayGanGai() {
		String input = "ami banglay gan gai";
		String output = avro.parse(input);
		assertEquals("আমি বাংলায় গান গাই", output);
	}

}