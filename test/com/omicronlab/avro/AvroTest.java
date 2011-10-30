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

import static org.junit.Assert.*;

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
	
	@Test
	public void testRandomChars() {
		String input = "ami banglay gan gai";
		String output = avro.parse(input);
		assertEquals("আমি বাংলায় গান গাই", output);
	}
	
	@Test
	public void basicTest() {
		//Goal: At least one test per conversion rule
		
		assertEquals("ভ্ল", avro.parse("bhl"));
		assertEquals("", avro.parse("bj"));
		assertEquals("", avro.parse("bd"));
		assertEquals("", avro.parse("bb"));
		assertEquals("", avro.parse("bl"));
		assertEquals("", avro.parse("bh"));
		assertEquals("", avro.parse("vl"));
		assertEquals("", avro.parse("b"));
		assertEquals("", avro.parse("v"));
		assertEquals("", avro.parse("cNG"));
		assertEquals("", avro.parse("cch"));
		assertEquals("", avro.parse("cc"));
		assertEquals("", avro.parse("ch"));
		assertEquals("", avro.parse("c"));
		assertEquals("", avro.parse("dhn"));
		assertEquals("", avro.parse("dhm"));
		assertEquals("", avro.parse("dgh"));
		assertEquals("", avro.parse("ddh"));
		assertEquals("", avro.parse("dbh"));
		assertEquals("", avro.parse("dv"));
		assertEquals("", avro.parse("dm"));
		assertEquals("", avro.parse("DD"));
		assertEquals("", avro.parse("Dh"));
		assertEquals("", avro.parse("dh"));
		assertEquals("", avro.parse("dg"));
		assertEquals("", avro.parse("dd"));
		assertEquals("", avro.parse("D"));
		assertEquals("", avro.parse("d"));
		assertEquals("", avro.parse("..."));
		assertEquals("", avro.parse(".`"));
		assertEquals("", avro.parse(".."));
		assertEquals("", avro.parse("."));
		assertEquals("", avro.parse("ghn"));
		assertEquals("", avro.parse("Ghn"));
		assertEquals("", avro.parse("gdh"));
		assertEquals("", avro.parse("gN"));
		assertEquals("", avro.parse("GN"));
		assertEquals("", avro.parse("gn"));
		assertEquals("", avro.parse("gm"));
		assertEquals("", avro.parse("Gm"));
		assertEquals("", avro.parse("gl"));
		assertEquals("", avro.parse("Gl"));
		assertEquals("", avro.parse("gg"));
		assertEquals("", avro.parse("GG"));
		assertEquals("", avro.parse("Gg"));
		assertEquals("", avro.parse("gG"));
		assertEquals("", avro.parse("gh"));
		assertEquals("", avro.parse("Gh"));
		assertEquals("", avro.parse("g"));
		assertEquals("", avro.parse("hN"));
		assertEquals("", avro.parse("hn"));
		assertEquals("", avro.parse("hm"));
		assertEquals("", avro.parse("hl"));
		assertEquals("", avro.parse("h"));
		assertEquals("", avro.parse("jjh"));
		assertEquals("", avro.parse("jNG"));
		assertEquals("", avro.parse("jh"));
		assertEquals("", avro.parse("jj"));
		assertEquals("", avro.parse("j"));
		assertEquals("", avro.parse("J"));
		assertEquals("", avro.parse("kkhN"));
		assertEquals("", avro.parse("kShN"));
		assertEquals("", avro.parse("kkhm"));
		assertEquals("", avro.parse("kShm"));
		assertEquals("", avro.parse("kxN"));
		assertEquals("", avro.parse("kxm"));
		assertEquals("", avro.parse("kkh"));
		assertEquals("", avro.parse("kSh"));
		assertEquals("", avro.parse("ksh"));
		assertEquals("", avro.parse("kx"));
		assertEquals("", avro.parse("kk"));
		assertEquals("", avro.parse("kT"));
		assertEquals("", avro.parse("kt"));
		assertEquals("", avro.parse("kl"));
		assertEquals("", avro.parse("ks"));
		assertEquals("", avro.parse("kh"));
		assertEquals("", avro.parse("k"));
		assertEquals("", avro.parse("lbh"));
		assertEquals("", avro.parse("ldh"));
		assertEquals("", avro.parse("lkh"));
		assertEquals("", avro.parse("lgh"));
		assertEquals("", avro.parse("lph"));
		assertEquals("", avro.parse("lk"));
		assertEquals("", avro.parse("lg"));
		assertEquals("", avro.parse("lT"));
		assertEquals("", avro.parse("lD"));
		assertEquals("", avro.parse("lp"));
		assertEquals("", avro.parse("lv"));
		assertEquals("", avro.parse("lm"));
		assertEquals("", avro.parse("ll"));
		assertEquals("", avro.parse("lb"));
		assertEquals("", avro.parse("l"));
		assertEquals("", avro.parse("mth"));
		assertEquals("", avro.parse("mph"));
		assertEquals("", avro.parse("mbh"));
		assertEquals("", avro.parse("mpl"));
		assertEquals("", avro.parse("mn"));
		assertEquals("", avro.parse("mp"));
		assertEquals("", avro.parse("mv"));
		assertEquals("", avro.parse("mm"));
		assertEquals("", avro.parse("ml"));
		assertEquals("", avro.parse("mb"));
		assertEquals("", avro.parse("mf"));
		assertEquals("", avro.parse("m"));
		assertEquals("", avro.parse("0"));
		assertEquals("", avro.parse("1"));
		assertEquals("", avro.parse("2"));
		assertEquals("", avro.parse("3"));
		assertEquals("", avro.parse("4"));
		assertEquals("", avro.parse("5"));
		assertEquals("", avro.parse("6"));
		assertEquals("", avro.parse("7"));
		assertEquals("", avro.parse("8"));
		assertEquals("", avro.parse("9"));
		assertEquals("", avro.parse("NgkSh"));
		assertEquals("", avro.parse("Ngkkh"));
		assertEquals("", avro.parse("NGch"));
		assertEquals("", avro.parse("NGch"));
		assertEquals("", avro.parse("Nggh"));
		assertEquals("", avro.parse("Ngkh"));
		assertEquals("", avro.parse("NGjh"));
		assertEquals("", avro.parse("ngOU"));
		assertEquals("", avro.parse("ngOI"));
		assertEquals("", avro.parse("Ngkx"));
		assertEquals("", avro.parse("NGc"));
		assertEquals("", avro.parse("nch"));
		assertEquals("", avro.parse("njh"));
		assertEquals("", avro.parse("ngh"));
		assertEquals("", avro.parse("Ngk"));
		assertEquals("", avro.parse("Ngx"));
		assertEquals("", avro.parse("Ngg"));
		assertEquals("", avro.parse("Ngm"));
		assertEquals("", avro.parse("NGj"));
		assertEquals("", avro.parse("ndh"));
		assertEquals("", avro.parse("nTh"));
		assertEquals("", avro.parse("NTh"));
		assertEquals("", avro.parse("NTh"));
		assertEquals("", avro.parse("nth"));
		assertEquals("", avro.parse("nkh"));
		assertEquals("", avro.parse("ngo"));
		assertEquals("", avro.parse("nga"));
		assertEquals("", avro.parse("ngi"));
		assertEquals("", avro.parse("ngI"));
		assertEquals("", avro.parse("ngu"));
		assertEquals("", avro.parse("ngU"));
		assertEquals("", avro.parse("nge"));
		assertEquals("", avro.parse("ngO"));
		assertEquals("", avro.parse("NDh"));
		assertEquals("", avro.parse("nsh"));
		assertEquals("", avro.parse("Ngr"));
		assertEquals("", avro.parse("NGr"));
		assertEquals("", avro.parse("ngr"));
		assertEquals("", avro.parse("nj"));
		assertEquals("", avro.parse("Ng"));
		assertEquals("", avro.parse("NG"));
		assertEquals("", avro.parse("nk"));
		assertEquals("", avro.parse("ng"));
		assertEquals("", avro.parse("nn"));
		assertEquals("", avro.parse("NN"));
		assertEquals("", avro.parse("Nn"));
		assertEquals("", avro.parse("nm"));
		assertEquals("", avro.parse("Nm"));
		assertEquals("", avro.parse("nd"));
		assertEquals("", avro.parse("nT"));
		assertEquals("", avro.parse("NT"));
		assertEquals("", avro.parse("nD"));
		assertEquals("", avro.parse("ND"));
		assertEquals("", avro.parse("nt"));
		assertEquals("", avro.parse("ns"));
		assertEquals("", avro.parse("nc"));
		assertEquals("", avro.parse("n"));
		assertEquals("", avro.parse("N"));
		assertEquals("", avro.parse("OI`"));
		assertEquals("", avro.parse("OU`"));
		assertEquals("", avro.parse("O`"));
		assertEquals("", avro.parse("OI"));
		assertEquals("", avro.parse("kOI"));
		assertEquals("", avro.parse(" OI"));
		assertEquals("", avro.parse("(OI"));
		assertEquals("", avro.parse(".OI"));
		assertEquals("", avro.parse("OU"));
		assertEquals("", avro.parse("kOU"));
		assertEquals("", avro.parse(" OU"));
		assertEquals("", avro.parse("-OU"));
		assertEquals("", avro.parse(",,OU"));
		assertEquals("", avro.parse("O"));
		assertEquals("", avro.parse("pO"));
		assertEquals("", avro.parse(" O"));
		assertEquals("", avro.parse("iO"));
		assertEquals("", avro.parse("`O"));
		assertEquals("", avro.parse("phl"));
		assertEquals("", avro.parse("pT"));
		assertEquals("", avro.parse("pt"));
		assertEquals("", avro.parse("pn"));
		assertEquals("", avro.parse("pp"));
		assertEquals("", avro.parse("pl"));
		assertEquals("", avro.parse("ps"));
		assertEquals("", avro.parse("ph"));
		assertEquals("", avro.parse("fl"));
		assertEquals("", avro.parse("f"));
		assertEquals("", avro.parse("p"));
		assertEquals("", avro.parse("rri`"));
		assertEquals("", avro.parse("rri"));
		assertEquals("", avro.parse("krri"));
		assertEquals("", avro.parse("Irri"));
		assertEquals("", avro.parse("^rri"));
		assertEquals("", avro.parse(":rri"));
		assertEquals("", avro.parse("rZ"));
		assertEquals("", avro.parse("krZ"));
		assertEquals("", avro.parse("rrZ"));
		assertEquals("", avro.parse("yrZ"));
		assertEquals("", avro.parse("wrZ"));
		assertEquals("", avro.parse("xrZ"));
		assertEquals("", avro.parse("irZ"));
		assertEquals("", avro.parse("-rZ"));
		assertEquals("", avro.parse("rrrZ"));
		assertEquals("", avro.parse("ry"));
		assertEquals("", avro.parse("qry"));
		assertEquals("", avro.parse("rry"));
		assertEquals("", avro.parse("yry"));
		assertEquals("", avro.parse("wry"));
		assertEquals("", avro.parse("xry"));
		assertEquals("", avro.parse("0ry"));
		assertEquals("", avro.parse("rrrry"));
		assertEquals("", avro.parse("Rry"));
		assertEquals("", avro.parse("rr"));
		assertEquals("", avro.parse("arr"));
		assertEquals("", avro.parse("arrk"));
		assertEquals("", avro.parse("arra"));
		assertEquals("", avro.parse("arr"));
		assertEquals("", avro.parse("arr!"));
		assertEquals("", avro.parse("krr"));
		assertEquals("", avro.parse("krra"));
		assertEquals("", avro.parse("Rg"));
		assertEquals("", avro.parse("Rh"));
		assertEquals("", avro.parse("R"));
		assertEquals("", avro.parse("r"));
		assertEquals("", avro.parse("or"));
		assertEquals("", avro.parse("mr"));
		assertEquals("", avro.parse("1r"));
		assertEquals("", avro.parse("+r"));
		assertEquals("", avro.parse("rr"));
		assertEquals("", avro.parse("yr"));
		assertEquals("", avro.parse("wr"));
		assertEquals("", avro.parse("xr"));
		assertEquals("", avro.parse("zr"));
		assertEquals("", avro.parse("mri"));
		assertEquals("", avro.parse("shch"));
		assertEquals("", avro.parse("ShTh"));
		assertEquals("", avro.parse("Shph"));
		assertEquals("", avro.parse("Sch"));
		assertEquals("", avro.parse("skl"));
		assertEquals("", avro.parse("skh"));
		assertEquals("", avro.parse("sth"));
		assertEquals("", avro.parse("sph"));
		assertEquals("", avro.parse("shc"));
		assertEquals("", avro.parse("sht"));
		assertEquals("", avro.parse("shn"));
		assertEquals("", avro.parse("shm"));
		assertEquals("", avro.parse("shl"));
		assertEquals("", avro.parse("Shk"));
		assertEquals("", avro.parse("ShT"));
		assertEquals("", avro.parse("ShN"));
		assertEquals("", avro.parse("Shp"));
		assertEquals("", avro.parse("Shf"));
		assertEquals("", avro.parse("Shm"));
		assertEquals("", avro.parse("spl"));
		assertEquals("", avro.parse("sk"));
		assertEquals("", avro.parse("Sc"));
		assertEquals("", avro.parse("sT"));
		assertEquals("", avro.parse("st"));
		assertEquals("", avro.parse("sn"));
		assertEquals("", avro.parse("sp"));
		assertEquals("", avro.parse("sf"));
		assertEquals("", avro.parse("sm"));
		assertEquals("", avro.parse("sl"));
		assertEquals("", avro.parse("sh"));
		assertEquals("", avro.parse("Sc"));
		assertEquals("", avro.parse("St"));
		assertEquals("", avro.parse("Sn"));
		assertEquals("", avro.parse("Sm"));
		assertEquals("", avro.parse("Sl"));
		assertEquals("", avro.parse("Sh"));
		assertEquals("", avro.parse("s"));
		assertEquals("", avro.parse("S"));
		assertEquals("", avro.parse("oo"));
		assertEquals("", avro.parse("OO"));
		assertEquals("", avro.parse("oo`"));
		assertEquals("", avro.parse("koo"));
		assertEquals("", avro.parse("ooo"));
		assertEquals("", avro.parse("!oo"));
		assertEquals("", avro.parse("!ooo"));
		assertEquals("", avro.parse("aoo"));
		assertEquals("", avro.parse("oop"));
		assertEquals("", avro.parse("ooo`"));
		assertEquals("", avro.parse("o`"));
		assertEquals("", avro.parse("oZ"));
		assertEquals("", avro.parse("oY"));
		assertEquals("", avro.parse("o"));
		assertEquals("", avro.parse("!o"));
		assertEquals("", avro.parse("^o"));
		assertEquals("", avro.parse("*o"));
		assertEquals("", avro.parse("io"));
		assertEquals("", avro.parse("yo"));
		assertEquals("", avro.parse("no"));
		assertEquals("", avro.parse("tth"));
		assertEquals("", avro.parse("t``"));
		assertEquals("", avro.parse("`t``"));
		assertEquals("", avro.parse("t``t``"));
		assertEquals("", avro.parse("t```"));
		assertEquals("", avro.parse("TT"));
		assertEquals("", avro.parse("Tm"));
		assertEquals("", avro.parse("Th"));
		assertEquals("", avro.parse("tn"));
		assertEquals("", avro.parse("tm"));
		assertEquals("", avro.parse("th"));
		assertEquals("", avro.parse("tt"));
		assertEquals("", avro.parse("T"));
		assertEquals("", avro.parse("t"));
		assertEquals("", avro.parse("aZ"));
		assertEquals("", avro.parse("aaZ"));
		assertEquals("", avro.parse("AZ"));
		assertEquals("", avro.parse("a`"));
		assertEquals("", avro.parse("a``"));
		assertEquals("", avro.parse("ka`"));
		assertEquals("", avro.parse("A`"));
		assertEquals("", avro.parse("a"));
		assertEquals("", avro.parse("`a"));
		assertEquals("", avro.parse("k`a"));
		assertEquals("", avro.parse("ia"));
		assertEquals("", avro.parse("aaaa`"));
		assertEquals("", avro.parse("i`"));
		assertEquals("", avro.parse("i"));
		assertEquals("", avro.parse("`i"));
		assertEquals("", avro.parse("hi"));
		assertEquals("", avro.parse("ih"));
		assertEquals("", avro.parse("i`h"));
		assertEquals("", avro.parse("I`"));
		assertEquals("", avro.parse("I"));
		assertEquals("", avro.parse("cI"));
		assertEquals("", avro.parse("Ix"));
		assertEquals("", avro.parse("II"));
		assertEquals("", avro.parse("0I"));
		assertEquals("", avro.parse("oI"));
		assertEquals("", avro.parse("u`"));
		assertEquals("", avro.parse("u"));
		assertEquals("", avro.parse("ku"));
		assertEquals("", avro.parse("uk"));
		assertEquals("", avro.parse("uu"));
		assertEquals("", avro.parse("iu"));
		assertEquals("", avro.parse("&u"));
		assertEquals("", avro.parse("u&"));
		assertEquals("", avro.parse("U`"));
		assertEquals("", avro.parse("U"));
		assertEquals("", avro.parse("yU"));
		assertEquals("", avro.parse("Uy"));
		assertEquals("", avro.parse("^U"));
		assertEquals("", avro.parse("U^"));
		assertEquals("", avro.parse("EE"));
		assertEquals("", avro.parse("ee"));
		assertEquals("", avro.parse("Ee"));
		assertEquals("", avro.parse("eE"));
		assertEquals("", avro.parse("ee`"));
		assertEquals("", avro.parse("kee"));
		assertEquals("", avro.parse("eek"));
		assertEquals("", avro.parse("0ee"));
		assertEquals("", avro.parse("ee8"));
		assertEquals("", avro.parse("(ee)"));
		assertEquals("", avro.parse("e`"));
		assertEquals("", avro.parse("e"));
		assertEquals("", avro.parse("ke"));
		assertEquals("", avro.parse("we"));
		assertEquals("", avro.parse("#e#"));
		assertEquals("", avro.parse("`e`"));
		assertEquals("", avro.parse("z"));
		assertEquals("", avro.parse("Z"));
		assertEquals("", avro.parse("rZ"));
		assertEquals("", avro.parse("kZS"));
		assertEquals("", avro.parse("y"));
		assertEquals("", avro.parse("oy"));
		assertEquals("", avro.parse("ky"));
		assertEquals("", avro.parse("ya"));
		assertEquals("", avro.parse("yaa"));
		assertEquals("", avro.parse("Y"));
		assertEquals("", avro.parse("YY"));
		assertEquals("", avro.parse("iY"));
		assertEquals("", avro.parse("kY"));
		assertEquals("", avro.parse("q"));
		assertEquals("", avro.parse("Q"));
		assertEquals("", avro.parse("w"));
		assertEquals("", avro.parse("wa"));
		assertEquals("", avro.parse("-wa-"));
		assertEquals("", avro.parse("woo"));
		assertEquals("", avro.parse("wre"));
		assertEquals("", avro.parse("kw"));
		assertEquals("", avro.parse("x"));
		assertEquals("", avro.parse("ex"));
		assertEquals("", avro.parse("bx"));
		assertEquals("", avro.parse(":`"));
		assertEquals("", avro.parse(":"));
		assertEquals("", avro.parse("^`"));
		assertEquals("", avro.parse("^"));
		assertEquals("", avro.parse("k^"));
		assertEquals("", avro.parse("k^i"));
		assertEquals("", avro.parse("ki^"));
		assertEquals("", avro.parse(",,"));
		assertEquals("", avro.parse(",,,"));
		assertEquals("", avro.parse(",,`,"));
		assertEquals("", avro.parse("`,,"));
		assertEquals("", avro.parse(",`,"));
		assertEquals("", avro.parse("$"));
		assertEquals("", avro.parse("`"));

	}

}