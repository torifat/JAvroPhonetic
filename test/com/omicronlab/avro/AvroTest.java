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

	Contributor(s): Mehdi Hasan <mhasan@omicronlab.com>.

	*****************************************************************************
	=============================================================================
*/

package com.omicronlab.avro;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/*
Note: 	If all tests fail, make sure the source file encoding is utf8.
		In Eclipse IDE: Edit menu>Set Encoding>utf8

*/

public class AvroTest {

	private PhoneticParser avro;

	@Before
	public void beforeTest() {
		try {
			 avro = PhoneticParser.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something very unholy has just happened :|");
		}
	}

	// XML Configuration Tests
	@Test
	public void xmlTestSentances() {
		avro.setLoader( new PhoneticXmlLoader() );
		this.testSentances();
	}

	@Test
	public void xmlTestRandomChars() {
		avro.setLoader( new PhoneticXmlLoader() );
		this.testRandomChars();
	}

	@Test
	public void xmlBasicTest() {
		avro.setLoader( new PhoneticXmlLoader() );
		this.basicTest();
	}

	// Test Functions
	private void testSentances() {
		//Goal: Test Sentence conversion
		assertEquals("আমি বাংলায় গান গাই",  avro.parse("ami banglay gan gai"));
		assertEquals("আমাদের ভালোবাসা হয়ে গেল ঘাস, খেয়ে গেল গরু আর দিয়ে গেল বাঁশ",  avro.parse("amader valObasa hoye gel ghas, kheye gel goru ar diye gelo ba^sh"));
	}

	private void testRandomChars() {
		//Goal: Test punctuation and other Unicode character (including Bangla)
		assertEquals("!", avro.parse("!"));
	}

	private void basicTest() {
		//Goal: At least one test per conversion rule

		assertEquals("ভ্ল", avro.parse("bhl"));
		assertEquals("ব্জ", avro.parse("bj"));
		assertEquals("ব্দ", avro.parse("bd"));
		assertEquals("ব্ব", avro.parse("bb"));
		assertEquals("ব্ল", avro.parse("bl"));
		assertEquals("ভ", avro.parse("bh"));
		assertEquals("ভ্ল", avro.parse("vl"));
		assertEquals("ব", avro.parse("b"));
		assertEquals("ভ", avro.parse("v"));
		assertEquals("চ্ঞ", avro.parse("cNG"));
		assertEquals("চ্ছ", avro.parse("cch"));
		assertEquals("চ্চ", avro.parse("cc"));
		assertEquals("ছ", avro.parse("ch"));
		assertEquals("চ", avro.parse("c"));
		assertEquals("ধ্ন", avro.parse("dhn"));
		assertEquals("ধ্ম", avro.parse("dhm"));
		assertEquals("দ্ঘ", avro.parse("dgh"));
		assertEquals("দ্ধ", avro.parse("ddh"));
		assertEquals("দ্ভ", avro.parse("dbh"));
		assertEquals("দ্ভ", avro.parse("dv"));
		assertEquals("দ্ম", avro.parse("dm"));
		assertEquals("ড্ড", avro.parse("DD"));
		assertEquals("ঢ", avro.parse("Dh"));
		assertEquals("ধ", avro.parse("dh"));
		assertEquals("দ্গ", avro.parse("dg"));
		assertEquals("দ্দ", avro.parse("dd"));
		assertEquals("ড", avro.parse("D"));
		assertEquals("দ", avro.parse("d"));
		assertEquals("...", avro.parse("..."));
		assertEquals(".", avro.parse(".`"));
		assertEquals("।।", avro.parse(".."));
		assertEquals("।", avro.parse("."));
		assertEquals("ঘ্ন", avro.parse("ghn"));
		assertEquals("ঘ্ন", avro.parse("Ghn"));
		assertEquals("গ্ধ", avro.parse("gdh"));
		assertEquals("গ্ণ", avro.parse("gN"));
		assertEquals("গ্ণ", avro.parse("GN"));
		assertEquals("গ্ন", avro.parse("gn"));
		assertEquals("গ্ম", avro.parse("gm"));
		assertEquals("গ্ম", avro.parse("Gm"));
		assertEquals("গ্ল", avro.parse("gl"));
		assertEquals("গ্ল", avro.parse("Gl"));
		assertEquals("জ্ঞ", avro.parse("gg"));
		assertEquals("জ্ঞ", avro.parse("GG"));
		assertEquals("জ্ঞ", avro.parse("Gg"));
		assertEquals("জ্ঞ", avro.parse("gG"));
		assertEquals("ঘ", avro.parse("gh"));
		assertEquals("ঘ", avro.parse("Gh"));
		assertEquals("গ", avro.parse("g"));
		assertEquals("হ্ণ", avro.parse("hN"));
		assertEquals("হ্ন", avro.parse("hn"));
		assertEquals("হ্ম", avro.parse("hm"));
		assertEquals("হ্ল", avro.parse("hl"));
		assertEquals("হ", avro.parse("h"));
		assertEquals("জ্ঝ", avro.parse("jjh"));
		assertEquals("জ্ঞ", avro.parse("jNG"));
		assertEquals("ঝ", avro.parse("jh"));
		assertEquals("জ্জ", avro.parse("jj"));
		assertEquals("জ", avro.parse("j"));
		assertEquals("জ", avro.parse("J"));
		assertEquals("ক্ষ্ণ", avro.parse("kkhN"));
		assertEquals("ক্ষ্ণ", avro.parse("kShN"));
		assertEquals("ক্ষ্ম", avro.parse("kkhm"));
		assertEquals("ক্ষ্ম", avro.parse("kShm"));
		assertEquals("ক্ষ্ণ", avro.parse("kxN"));
		assertEquals("ক্ষ্ম", avro.parse("kxm"));
		assertEquals("ক্ষ", avro.parse("kkh"));
		assertEquals("ক্ষ", avro.parse("kSh"));
		assertEquals("কশ", avro.parse("ksh"));
		assertEquals("ক্ষ", avro.parse("kx"));
		assertEquals("ক্ক", avro.parse("kk"));
		assertEquals("ক্ট", avro.parse("kT"));
		assertEquals("ক্ত", avro.parse("kt"));
		assertEquals("ক্ল", avro.parse("kl"));
		assertEquals("ক্স", avro.parse("ks"));
		assertEquals("খ", avro.parse("kh"));
		assertEquals("ক", avro.parse("k"));
		assertEquals("ল্ভ", avro.parse("lbh"));
		assertEquals("ল্ধ", avro.parse("ldh"));
		assertEquals("লখ", avro.parse("lkh"));
		assertEquals("লঘ", avro.parse("lgh"));
		assertEquals("লফ", avro.parse("lph"));
		assertEquals("ল্ক", avro.parse("lk"));
		assertEquals("ল্গ", avro.parse("lg"));
		assertEquals("ল্ট", avro.parse("lT"));
		assertEquals("ল্ড", avro.parse("lD"));
		assertEquals("ল্প", avro.parse("lp"));
		assertEquals("ল্ভ", avro.parse("lv"));
		assertEquals("ল্ম", avro.parse("lm"));
		assertEquals("ল্ল", avro.parse("ll"));
		assertEquals("ল্ব", avro.parse("lb"));
		assertEquals("ল", avro.parse("l"));
		assertEquals("ম্থ", avro.parse("mth"));
		assertEquals("ম্ফ", avro.parse("mph"));
		assertEquals("ম্ভ", avro.parse("mbh"));
		assertEquals("মপ্ল", avro.parse("mpl"));
		assertEquals("ম্ন", avro.parse("mn"));
		assertEquals("ম্প", avro.parse("mp"));
		assertEquals("ম্ভ", avro.parse("mv"));
		assertEquals("ম্ম", avro.parse("mm"));
		assertEquals("ম্ল", avro.parse("ml"));
		assertEquals("ম্ব", avro.parse("mb"));
		assertEquals("ম্ফ", avro.parse("mf"));
		assertEquals("ম", avro.parse("m"));
		assertEquals("০", avro.parse("0"));
		assertEquals("১", avro.parse("1"));
		assertEquals("২", avro.parse("2"));
		assertEquals("৩", avro.parse("3"));
		assertEquals("৪", avro.parse("4"));
		assertEquals("৫", avro.parse("5"));
		assertEquals("৬", avro.parse("6"));
		assertEquals("৭", avro.parse("7"));
		assertEquals("৮", avro.parse("8"));
		assertEquals("৯", avro.parse("9"));
		assertEquals("ঙ্ক্ষ", avro.parse("NgkSh"));
		assertEquals("ঙ্ক্ষ", avro.parse("Ngkkh"));
		assertEquals("ঞ্ছ", avro.parse("NGch"));
		assertEquals("ঙ্ঘ", avro.parse("Nggh"));
		assertEquals("ঙ্খ", avro.parse("Ngkh"));
		assertEquals("ঞ্ঝ", avro.parse("NGjh"));
		assertEquals("ঙ্গৌ", avro.parse("ngOU"));
		assertEquals("ঙ্গৈ", avro.parse("ngOI"));
		assertEquals("ঙ্ক্ষ", avro.parse("Ngkx"));
		assertEquals("ঞ্চ", avro.parse("NGc"));
		assertEquals("ঞ্ছ", avro.parse("nch"));
		assertEquals("ঞ্ঝ", avro.parse("njh"));
		assertEquals("ঙ্ঘ", avro.parse("ngh"));
		assertEquals("ঙ্ক", avro.parse("Ngk"));
		assertEquals("ঙ্ষ", avro.parse("Ngx"));
		assertEquals("ঙ্গ", avro.parse("Ngg"));
		assertEquals("ঙ্ম", avro.parse("Ngm"));
		assertEquals("ঞ্জ", avro.parse("NGj"));
		assertEquals("ন্ধ", avro.parse("ndh"));
		assertEquals("ন্ঠ", avro.parse("nTh"));
		assertEquals("ণ্ঠ", avro.parse("NTh"));
		assertEquals("ন্থ", avro.parse("nth"));
		assertEquals("ঙ্খ", avro.parse("nkh"));
		assertEquals("ঙ্গ", avro.parse("ngo"));
		assertEquals("ঙ্গা", avro.parse("nga"));
		assertEquals("ঙ্গি", avro.parse("ngi"));
		assertEquals("ঙ্গী", avro.parse("ngI"));
		assertEquals("ঙ্গু", avro.parse("ngu"));
		assertEquals("ঙ্গূ", avro.parse("ngU"));
		assertEquals("ঙ্গে", avro.parse("nge"));
		assertEquals("ঙ্গো", avro.parse("ngO"));
		assertEquals("ণ্ঢ", avro.parse("NDh"));
		assertEquals("নশ", avro.parse("nsh"));
		assertEquals("ঙর", avro.parse("Ngr"));
		assertEquals("ঞর", avro.parse("NGr"));
		assertEquals("ংর", avro.parse("ngr"));
		assertEquals("ঞ্জ", avro.parse("nj"));
		assertEquals("ঙ", avro.parse("Ng"));
		assertEquals("ঞ", avro.parse("NG"));
		assertEquals("ঙ্ক", avro.parse("nk"));
		assertEquals("ং", avro.parse("ng"));
		assertEquals("ন্ন", avro.parse("nn"));
		assertEquals("ণ্ণ", avro.parse("NN"));
		assertEquals("ণ্ন", avro.parse("Nn"));
		assertEquals("ন্ম", avro.parse("nm"));
		assertEquals("ণ্ম", avro.parse("Nm"));
		assertEquals("ন্দ", avro.parse("nd"));
		assertEquals("ন্ট", avro.parse("nT"));
		assertEquals("ণ্ট", avro.parse("NT"));
		assertEquals("ন্ড", avro.parse("nD"));
		assertEquals("ণ্ড", avro.parse("ND"));
		assertEquals("ন্ত", avro.parse("nt"));
		assertEquals("ন্স", avro.parse("ns"));
		assertEquals("ঞ্চ", avro.parse("nc"));
		assertEquals("ন", avro.parse("n"));
		assertEquals("ণ", avro.parse("N"));
		assertEquals("ৈ", avro.parse("OI`"));
		assertEquals("ৌ", avro.parse("OU`"));
		assertEquals("ো", avro.parse("O`"));
		assertEquals("ঐ", avro.parse("OI"));
		assertEquals("কৈ", avro.parse("kOI"));
		assertEquals(" ঐ", avro.parse(" OI"));
		assertEquals("(ঐ", avro.parse("(OI"));
		assertEquals("।ঐ", avro.parse(".OI"));
		assertEquals("ঔ", avro.parse("OU"));
		assertEquals("কৌ", avro.parse("kOU"));
		assertEquals(" ঔ", avro.parse(" OU"));
		assertEquals("-ঔ", avro.parse("-OU"));
		assertEquals("্‌ঔ", avro.parse(",,OU"));
		assertEquals("ও", avro.parse("O"));
		assertEquals("পো", avro.parse("pO"));
		assertEquals(" ও", avro.parse(" O"));
		assertEquals("ইও", avro.parse("iO"));
		assertEquals("ও", avro.parse("`O"));
		assertEquals("ফ্ল", avro.parse("phl"));
		assertEquals("প্ট", avro.parse("pT"));
		assertEquals("প্ত", avro.parse("pt"));
		assertEquals("প্ন", avro.parse("pn"));
		assertEquals("প্প", avro.parse("pp"));
		assertEquals("প্ল", avro.parse("pl"));
		assertEquals("প্স", avro.parse("ps"));
		assertEquals("ফ", avro.parse("ph"));
		assertEquals("ফ্ল", avro.parse("fl"));
		assertEquals("ফ", avro.parse("f"));
		assertEquals("প", avro.parse("p"));
		assertEquals("ৃ", avro.parse("rri`"));
		assertEquals("ঋ", avro.parse("rri"));
		assertEquals("কৃ", avro.parse("krri"));
		assertEquals("ঈঋ", avro.parse("Irri"));
		assertEquals("ঁঋ", avro.parse("^rri"));
		assertEquals("ঃঋ", avro.parse(":rri"));
		assertEquals("র‍্য", avro.parse("rZ"));
		assertEquals("ক্র্য", avro.parse("krZ"));
		assertEquals("রর‍্য", avro.parse("rrZ"));
		assertEquals("ইয়র‍্য", avro.parse("yrZ"));
		assertEquals("ওর‍্য", avro.parse("wrZ"));
		assertEquals("এক্সর‍্য", avro.parse("xrZ"));
		assertEquals("ইর‍্য", avro.parse("irZ"));
		assertEquals("-র‍্য", avro.parse("-rZ"));
		assertEquals("ররর‍্য", avro.parse("rrrZ"));
		assertEquals("র‍্য", avro.parse("ry"));
		assertEquals("ক্র্য", avro.parse("qry"));
		assertEquals("রর‍্য", avro.parse("rry"));
		assertEquals("ইয়র‍্য", avro.parse("yry"));
		assertEquals("ওর‍্য", avro.parse("wry"));
		assertEquals("এক্সর‍্য", avro.parse("xry"));
		assertEquals("০র‍্য", avro.parse("0ry"));
		assertEquals("রররর‍্য", avro.parse("rrrry"));
		assertEquals("ড়্র্য", avro.parse("Rry"));
		assertEquals("রর", avro.parse("rr"));
		assertEquals("আরর", avro.parse("arr"));
		assertEquals("আর্ক", avro.parse("arrk"));
		assertEquals("আররা", avro.parse("arra"));
		assertEquals("আরর", avro.parse("arr"));
		assertEquals("আরর!", avro.parse("arr!"));
		assertEquals("ক্রর", avro.parse("krr"));
		assertEquals("ক্ররা", avro.parse("krra"));
		assertEquals("ড়্গ", avro.parse("Rg"));
		assertEquals("ঢ়", avro.parse("Rh"));
		assertEquals("ড়", avro.parse("R"));
		assertEquals("র", avro.parse("r"));
		assertEquals("অর", avro.parse("or"));
		assertEquals("ম্র", avro.parse("mr"));
		assertEquals("১র", avro.parse("1r"));
		assertEquals("+র", avro.parse("+r"));
		assertEquals("রর", avro.parse("rr"));
		assertEquals("ইয়র", avro.parse("yr"));
		assertEquals("ওর", avro.parse("wr"));
		assertEquals("এক্সর", avro.parse("xr"));
		assertEquals("য্র", avro.parse("zr"));
		assertEquals("ম্রি", avro.parse("mri"));
		assertEquals("শ্ছ", avro.parse("shch"));
		assertEquals("ষ্ঠ", avro.parse("ShTh"));
		assertEquals("ষ্ফ", avro.parse("Shph"));
		assertEquals("শ্ছ", avro.parse("Sch"));
		assertEquals("স্ক্ল", avro.parse("skl"));
		assertEquals("স্খ", avro.parse("skh"));
		assertEquals("স্থ", avro.parse("sth"));
		assertEquals("স্ফ", avro.parse("sph"));
		assertEquals("শ্চ", avro.parse("shc"));
		assertEquals("শ্ত", avro.parse("sht"));
		assertEquals("শ্ন", avro.parse("shn"));
		assertEquals("শ্ম", avro.parse("shm"));
		assertEquals("শ্ল", avro.parse("shl"));
		assertEquals("ষ্ক", avro.parse("Shk"));
		assertEquals("ষ্ট", avro.parse("ShT"));
		assertEquals("ষ্ণ", avro.parse("ShN"));
		assertEquals("ষ্প", avro.parse("Shp"));
		assertEquals("ষ্ফ", avro.parse("Shf"));
		assertEquals("ষ্ম", avro.parse("Shm"));
		assertEquals("স্প্ল", avro.parse("spl"));
		assertEquals("স্ক", avro.parse("sk"));
		assertEquals("শ্চ", avro.parse("Sc"));
		assertEquals("স্ট", avro.parse("sT"));
		assertEquals("স্ত", avro.parse("st"));
		assertEquals("স্ন", avro.parse("sn"));
		assertEquals("স্প", avro.parse("sp"));
		assertEquals("স্ফ", avro.parse("sf"));
		assertEquals("স্ম", avro.parse("sm"));
		assertEquals("স্ল", avro.parse("sl"));
		assertEquals("শ", avro.parse("sh"));
		assertEquals("শ্চ", avro.parse("Sc"));
		assertEquals("শ্ত", avro.parse("St"));
		assertEquals("শ্ন", avro.parse("Sn"));
		assertEquals("শ্ম", avro.parse("Sm"));
		assertEquals("শ্ল", avro.parse("Sl"));
		assertEquals("ষ", avro.parse("Sh"));
		assertEquals("স", avro.parse("s"));
		assertEquals("শ", avro.parse("S"));
		assertEquals("উ", avro.parse("oo"));
		assertEquals("ওও", avro.parse("OO"));
		assertEquals("ু", avro.parse("oo`"));
		assertEquals("কু", avro.parse("koo"));
		assertEquals("উঅ", avro.parse("ooo"));
		assertEquals("!উ", avro.parse("!oo"));
		assertEquals("!উঅ", avro.parse("!ooo"));
		assertEquals("আউ", avro.parse("aoo"));
		assertEquals("উপ", avro.parse("oop"));
		assertEquals("উ", avro.parse("ooo`"));
		assertEquals("", avro.parse("o`"));
		assertEquals("অ্য", avro.parse("oZ"));
		assertEquals("অয়", avro.parse("oY"));
		assertEquals("অ", avro.parse("o"));
		assertEquals("!অ", avro.parse("!o"));
		assertEquals("ঁঅ", avro.parse("^o"));
		assertEquals("*অ", avro.parse("*o"));
		assertEquals("ইও", avro.parse("io"));
		assertEquals("ইয়", avro.parse("yo"));
		assertEquals("ন", avro.parse("no"));
		assertEquals("ত্থ", avro.parse("tth"));
		assertEquals("ৎ", avro.parse("t``"));
		assertEquals("ৎ", avro.parse("`t``"));
		assertEquals("ৎৎ", avro.parse("t``t``"));
		assertEquals("ৎ", avro.parse("t```"));
		assertEquals("ট্ট", avro.parse("TT"));
		assertEquals("ট্ম", avro.parse("Tm"));
		assertEquals("ঠ", avro.parse("Th"));
		assertEquals("ত্ন", avro.parse("tn"));
		assertEquals("ত্ম", avro.parse("tm"));
		assertEquals("থ", avro.parse("th"));
		assertEquals("ত্ত", avro.parse("tt"));
		assertEquals("ট", avro.parse("T"));
		assertEquals("ত", avro.parse("t"));
		assertEquals("অ্যা", avro.parse("aZ"));
		assertEquals("আঅ্যা", avro.parse("aaZ"));
		assertEquals("অ্যা", avro.parse("AZ"));
		assertEquals("া", avro.parse("a`"));
		assertEquals("া", avro.parse("a``"));
		assertEquals("কা", avro.parse("ka`"));
		assertEquals("া", avro.parse("A`"));
		assertEquals("আ", avro.parse("a"));
		assertEquals("আ", avro.parse("`a"));
		assertEquals("কআ", avro.parse("k`a"));
		assertEquals("ইয়া", avro.parse("ia"));
		assertEquals("আআআা", avro.parse("aaaa`"));
		assertEquals("ি", avro.parse("i`"));
		assertEquals("ই", avro.parse("i"));
		assertEquals("ই", avro.parse("`i"));
		assertEquals("হি", avro.parse("hi"));
		assertEquals("ইহ", avro.parse("ih"));
		assertEquals("িহ", avro.parse("i`h"));
		assertEquals("ী", avro.parse("I`"));
		assertEquals("ঈ", avro.parse("I"));
		assertEquals("চী", avro.parse("cI"));
		assertEquals("ঈক্স", avro.parse("Ix"));
		assertEquals("ঈঈ", avro.parse("II"));
		assertEquals("০ঈ", avro.parse("0I"));
		assertEquals("অঈ", avro.parse("oI"));
		assertEquals("ু", avro.parse("u`"));
		assertEquals("উ", avro.parse("u"));
		assertEquals("কু", avro.parse("ku"));
		assertEquals("উক", avro.parse("uk"));
		assertEquals("উউ", avro.parse("uu"));
		assertEquals("ইউ", avro.parse("iu"));
		assertEquals("&উ", avro.parse("&u"));
		assertEquals("উ&", avro.parse("u&"));
		assertEquals("ূ", avro.parse("U`"));
		assertEquals("ঊ", avro.parse("U"));
		assertEquals("ইয়ূ", avro.parse("yU"));
		assertEquals("ঊয়", avro.parse("Uy"));
		assertEquals("ঁঊ", avro.parse("^U"));
		assertEquals("ঊঁ", avro.parse("U^"));
		assertEquals("ঈ", avro.parse("EE"));
		assertEquals("ঈ", avro.parse("ee"));
		assertEquals("ঈ", avro.parse("Ee"));
		assertEquals("ঈ", avro.parse("eE"));
		assertEquals("ী", avro.parse("ee`"));
		assertEquals("কী", avro.parse("kee"));
		assertEquals("ঈক", avro.parse("eek"));
		assertEquals("০ঈ", avro.parse("0ee"));
		assertEquals("ঈ৮", avro.parse("ee8"));
		assertEquals("(ঈ)", avro.parse("(ee)"));
		assertEquals("ে", avro.parse("e`"));
		assertEquals("এ", avro.parse("e"));
		assertEquals("কে", avro.parse("ke"));
		assertEquals("ওয়ে", avro.parse("we"));
		assertEquals("#এ#", avro.parse("#e#"));
		assertEquals("ে", avro.parse("`e`"));
		assertEquals("য", avro.parse("z"));
		assertEquals("্য", avro.parse("Z"));
		assertEquals("র‍্য", avro.parse("rZ"));
		assertEquals("ক্যশ", avro.parse("kZS"));
		assertEquals("ইয়", avro.parse("y"));
		assertEquals("অয়", avro.parse("oy"));
		assertEquals("ক্য", avro.parse("ky"));
		assertEquals("ইয়া", avro.parse("ya"));
		assertEquals("ইয়াআ", avro.parse("yaa"));
		assertEquals("য়", avro.parse("Y"));
		assertEquals("য়য়", avro.parse("YY"));
		assertEquals("ইয়", avro.parse("iY"));
		assertEquals("কয়", avro.parse("kY"));
		assertEquals("ক", avro.parse("q"));
		assertEquals("ক", avro.parse("Q"));
		assertEquals("ও", avro.parse("w"));
		assertEquals("ওয়া", avro.parse("wa"));
		assertEquals("-ওয়া-", avro.parse("-wa-"));
		assertEquals("ওয়ু", avro.parse("woo"));
		assertEquals("ওরে", avro.parse("wre"));
		assertEquals("ক্ব", avro.parse("kw"));
		assertEquals("এক্স", avro.parse("x"));
		assertEquals("এক্স", avro.parse("ex"));
		assertEquals("বক্স", avro.parse("bx"));
		assertEquals(":", avro.parse(":`"));
		assertEquals("ঃ", avro.parse(":"));
		assertEquals("^", avro.parse("^`"));
		assertEquals("ঁ", avro.parse("^"));
		assertEquals("কঁ", avro.parse("k^"));
		assertEquals("কঁই", avro.parse("k^i"));
		assertEquals("কিঁ", avro.parse("ki^"));
		assertEquals("্‌", avro.parse(",,"));
		assertEquals("্‌,", avro.parse(",,,"));
		assertEquals("্‌,", avro.parse(",,`,"));
		assertEquals("্‌", avro.parse("`,,"));
		assertEquals(",,", avro.parse(",`,"));
		assertEquals("৳", avro.parse("$"));
		assertEquals("", avro.parse("`"));
		assertEquals("ব্ধ", avro.parse("bdh"));
	}

}