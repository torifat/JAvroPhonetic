package com.Omicronlab.Avro;

import org.apache.commons.lang3.StringUtils;

public class Avro {

	public static void main(String[] args) {
		if(args.length > 0) {
			PhoneticXmlLoader xmlLoader = null;
			try {
				 xmlLoader = new PhoneticXmlLoader("conf");
			} catch (Exception e) {
				System.out.println("Something very unholy has just happend :|");
			}
			PhoneticParser parser = PhoneticParser.getInstance();
			parser.setLoader(xmlLoader);
			
			String str = StringUtils.join(args, " ");
			String output = null;
			try {
				output = parser.parse(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(output);
		}
	}
}
