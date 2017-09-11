package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class VigenereTest {

	@Test
	public void test() {
		Cipher vigenereExample = new Vigenere();
		String s = vigenereExample.encrypt("CRYPTOGRAPHY","HELLO");
		assertEquals("CRYPTOGRAPHY encrypted and decrypted check","CRYPTOGRAPHY",vigenereExample.decrypt(s,"HELLO"));
		
		s = vigenereExample.encrypt("KSMEH ZBBLK SME", "RELAT IONSR ELA");
		assertEquals("CRYPTOGRAPHY encrypted and decrypted check","KSMEH ZBBLK SME",vigenereExample.decrypt(s,"RELAT IONSR ELA"));
		
	}

}
