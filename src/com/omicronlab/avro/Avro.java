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
