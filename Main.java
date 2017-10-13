package test;
import java.io.IOException;
import java.util.Scanner;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import test.session1.Caesar;
import test.session1.CaesarTest;
import test.session1.Cipher;
import test.session1.Vigenere;
import test.session2.SymmetricRC4;

public class Main {
	public static void main(String[] args) throws IOException {
		Result result = JUnitCore.runClasses(CaesarTest.class);	
		for (Failure failure : result.getFailures()) {
			         System.out.println(failure.toString());
		}
					
		System.out.println("Success status for caser encrypt encrypt class:" + result.wasSuccessful());
		
		//break the cipher example
		Caesar caesarhack = new Caesar();
		System.out.println(caesarhack.breakcypher("jvvr://yyy.iqqing.eqo"));
		
		Cipher v = new Vigenere();
		System.out.println(v.encrypt("TOBEO RNOTT OBE","RELAT IONSR ELA"));
		System.out.println(v.decrypt("KSMEH ZBBLK SME","RELAT IONSR ELA"));
		
		Cipher rc4 = new SymmetricRC4();
		System.out.println(rc4.encrypt("hello world","broits"));
		
		String crypto ="ThXJ3QdxaW3COCHVOSBtaW5keW8tciBtaW5keRphQIJtSPWtv+Ibt0fIwZhOh3B8V5Uyat7wwjh+Q+ShnPS4zGNCfsBKh4PDW7H1Hig63NQAP8425m28gxZsSXPzic2vrvgPuif0QBp9aW5lfWl1cykmaWlveG90USNsaGs5eW90ciwnaWZueP8kxOJtaWtlaHR1ESACaQBkHm8HckFtHW4XeUF1BiAVaRpkeW9heCFt6e3WfHVHoSF4b29kWe/B8yBt";
		@SuppressWarnings("restriction")
		byte[] decodedEncryptedMessage = new sun.misc.BASE64Decoder().decodeBuffer(crypto);
		//System.out.println(new String(decodedEncryptedMessage));
		
		Cipher rc4new = new SymmetricRC4();
		String key = "your mind";
		
		System.out.println(rc4new.decrypt(new String(decodedEncryptedMessage), key));
		
		
		
	}

}
