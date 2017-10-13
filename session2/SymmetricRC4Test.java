package test.session2;

import static org.junit.Assert.*;

import org.junit.Test;

import test.session1.Cipher;

public class SymmetricRC4Test {

	@Test
	public void test() {
		Cipher rc4 = new SymmetricRC4();
		String key ="1123456";
		String s = rc4.encrypt("hello world", key);
		assertEquals("hello world encrypted and decrypted check","hello world",rc4.decrypt(s, key));
		
		key ="112345ye";
		s = rc4.encrypt("this is ram1234", key);
		assertEquals("(this is ram1234) encrypted and decrypted check","this is ram1234",rc4.decrypt(s, key));
		
		
	}

}
