package test.session1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CaesarTest {

	@Test
	public void test() {
		Cipher exampleCaesar = new Caesar();
		int key = 2;
		//Interface requires all the key to be string
		String keyValue = String.valueOf(key);
		String s = exampleCaesar.encrypt("ram", keyValue);
		assertEquals("ram encrypted and decrypted check","ram",exampleCaesar.decrypt(s,keyValue));
		
		key = 26;
		//Interface requires all the key to be string
		keyValue = String.valueOf(key);
		
		s = exampleCaesar.encrypt("http://google.com", keyValue);
		assertEquals("http://google.com encrypted and decrypted","http://google.com",exampleCaesar.decrypt(s,keyValue));
	}

}
