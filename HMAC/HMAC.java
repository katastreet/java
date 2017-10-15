package test.HMAC;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class HMAC {
	private static final String algorithm="HmacSHA1";
	public static SecretKey HMACKeyGenerator() throws NoSuchAlgorithmException {
		KeyGenerator keyGen = KeyGenerator.getInstance(algorithm);
		SecureRandom random = new SecureRandom(); // secure random 
		keyGen.init(random); 
		return keyGen.generateKey();
	}
	
	public byte[] generateMAC(String message, SecretKey macKey) throws Exception {
		Mac mac = Mac.getInstance(algorithm);
		mac.init(macKey);
		
		return mac.doFinal(message.getBytes());
	}
	
	public boolean verifyMAC(String message, byte[] sentMAC, SecretKey macKey) throws Exception {
		byte[] generatedMAC = generateMAC(message, macKey);
		if(Arrays.equals(generatedMAC, sentMAC)) {
			return true;
		}
		else {
			return false;
		}
	}
}
