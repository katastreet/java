package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class junittest {

	@Test
	public void test() {
		ceaser c = new ceaser(2);
		String s = c.encrypt("ram");
		assertEquals("ram encrypted and decrypted check","ram",c.decrypt(s));
		c.setKey(52);
		s = c.encrypt("http://google.com");
		assertEquals("http://google.com encrypted and decrypted","http://google.com",c.decrypt(s));
	}

}
