package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class vigeneretest {

	@Test
	public void test() {
		vigenere c = new vigenere("HELLO");
		String s = c.encrypt("CRYPTOGRAPHY");
		assertEquals("CRYPTOGRAPHY encrypted and decrypted check","CRYPTOGRAPHY",c.decrypt(s));
		c.setKey("RELAT IONSR ELA");
		s = c.encrypt("KSMEH ZBBLK SME");
		assertEquals("CRYPTOGRAPHY encrypted and decrypted check","KSMEH ZBBLK SME",c.decrypt(s));
		
	}

}
