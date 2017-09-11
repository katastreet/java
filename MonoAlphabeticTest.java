package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonoAlphabeticTest {

	@Test
	public void test() {
		Cipher c = new MonoAlphabetic();
		String s = c.encrypt("CRYPTOGRAPHY","DEFGHIJKLMNOPQRSTUVWXYZABC");
		assertEquals("CRYPTOGRAPHY encrypted and decrypted check","CRYPTOGRAPHY",c.decrypt(s,"DEFGHIJKLMNOPQRSTUVWXYZABC"));

		s = c.encrypt("CIPHER","HTKCUOISJYARGMZNBVFPXDLWQE");
		assertEquals("CIPHER encrypted and decrypted check","CIPHER",c.decrypt(s,"HTKCUOISJYARGMZNBVFPXDLWQE"));
		
	}

}
