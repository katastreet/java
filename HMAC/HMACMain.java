package test.HMAC;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import test.session4.AES;

public class HMACMain {
	public static void main(String[] args) throws Exception {
		SecretKey aesKey = AESCipher.AESKeyGenerator();
		SecretKey hmacKey = HMAC.HMACKeyGenerator();
		IvParameterSpec ivParameterSpec = AESCipher.generateIV(16); 
		
		String message = "hello world how are you?";
		System.out.println("original message: " + message);
		
		HMAC hmac = new HMAC();
		
		//generate MAC to send in network
		byte[] generatedMAC = hmac.generateMAC(message, hmacKey);
		
		//encrypt message
		AESCipher aesCipher = new AESCipher();
		byte[] encryptedMessage = aesCipher.encrypt(message, aesKey, ivParameterSpec);
		
		
		System.out.println("encrypted message: " + Base64.getEncoder().encodeToString(encryptedMessage));
		
		
		
		// transferred in network pop pop ....
		
		byte[] sentMAC = generatedMAC.clone();
		
		
		byte[] decryptedMessage = aesCipher.decrypt(encryptedMessage, aesKey, ivParameterSpec);
		String originalMessage = new String(decryptedMessage);
		if(hmac.verifyMAC(originalMessage, sentMAC, hmacKey))
		{
			System.out.println("authentication verified");
		System.out.println("Decrypted on other side: " + originalMessage);
		}
		else {
			System.out.println("message authentication failed");
		}
		
	}

}
