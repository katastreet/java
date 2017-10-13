package test.session4;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Sess4 {
	public static void main(String[] args) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {
		AES aesexample = new AES();
		String message = "Hello world!";
		
		//16 bytes key for AES
		String key = "0123456789abcdef";
		
		byte[] encrypted =aesexample.encrypt(message, key);
		System.out.println(new String(encrypted));
		System.out.println(new String(aesexample.decrypt(encrypted, key)));
		
		byte[] iv = AES.generateIV(16);
		encrypted =aesexample.encryptCBC(message, key,iv);
		System.out.println(new String(encrypted));
		
		System.out.println(new String(aesexample.decryptCBC(encrypted, key, iv)));
		
		SecureRandom r = new SecureRandom();
		
		System.out.println(r.nextInt(555));
		System.out.println(r.nextInt(555));
		
		
		
		
	}

}
