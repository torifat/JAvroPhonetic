# JAvroPhonetic v1.2

A Java implementation of Avro Phonetic

Website: [OmicronLab.com](http://omicronlab.com/)

## Compilation

We use maven to handle our dependencies.

* Install [Maven 3](http://maven.apache.org/download.html)
* Check out this repo and: `mvn clean install`

## Usage
### With Built-in XML Loader & XML Rules
    PhoneticParser avro = PhoneticParser.getInstance();    
    avro.setLoader(new PhoneticXmlLoader());
	String bangla = avro.parse("ami banglay gan gai");
	System.out.println(bangla); // আমি বাংলায় গান গাই
	
### With Built-in XML Loader & Custom XML Rules File
    PhoneticParser parser = PhoneticParser.getInstance();
    String customXmlRulesFile = "/path/to/the/rules.xml";
    PhoneticLoader loader = new PhoneticXmlLoader(customXmlRulesFile);
    parser.setLoader(loader);
	String output = parser.parse("content to parse");
	
### With Custom Loader
	public class CustomLoader implements PhoneticLoader {
		…
		public Data getData() throws Exception {
			…
		}
		…
	}

---

    PhoneticParser parser = PhoneticParser.getInstance();
    parser.setLoader(new CustomLoader());
	String output = parser.parse("content to parse");
