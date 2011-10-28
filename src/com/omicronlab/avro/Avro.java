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

import org.apache.commons.lang3.StringUtils;

public class Avro {

	public static void main(String[] args) {
		if(args.length > 0) {
			PhoneticXmlLoader xmlLoader = null;
			try {
				 xmlLoader = new PhoneticXmlLoader("conf/phonetic.xml");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Something very unholy has just happened :|");
			}
			
			if(xmlLoader != null) {
				PhoneticParser parser = PhoneticParser.getInstance();
				parser.setLoader(xmlLoader);
				
				String str = StringUtils.join(args, " ");
				String output = null;
				try {
					output = parser.parse(str);
				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println(str);
				System.out.println(output);
			}
		}
	}
}
