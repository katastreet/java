package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class mononalphabetictest {

	@Test
	public void test() {
		monoalphabetic c = new monoalphabetic("DEFGHIJKLMNOPQRSTUVWXYZABC");
		String s = c.encrypt("CRYPTOGRAPHY");
		assertEquals("CRYPTOGRAPHY encrypted and decrypted check","CRYPTOGRAPHY",c.decrypt(s));
		c.setCipher("HTKCUOISJYARGMZNBVFPXDLWQE");
		s = c.encrypt("CIPHER");
		assertEquals("CIPHER encrypted and decrypted check","CIPHER",c.decrypt(s));
		
	}

}
