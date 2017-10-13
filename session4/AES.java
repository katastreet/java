package test.session4;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES{
	public static byte[] generateIV(int ivsize) {
		int ivSize  = 16;
		byte[] iv = new byte[ivSize];
		SecureRandom random = new SecureRandom();
		random.nextBytes(iv);
		return iv;
		
	}

	public byte[] encrypt(String text, String key) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
		byte[] message = text.getBytes();
		SecretKeySpec aesKey = new SecretKeySpec(key.getBytes(),"AES");
		Cipher aesCipher = Cipher.getInstance("AES");
		
		aesCipher.init(Cipher.ENCRYPT_MODE,aesKey);
		
		byte[] encryptedMessage = aesCipher.doFinal(message);
		return encryptedMessage;
		
		
	}

	public byte[] decrypt(byte[] text, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		byte[] encryptedMessage = text;
		SecretKeySpec aesKey = new SecretKeySpec(key.getBytes(),"AES");
		Cipher aesCipher = Cipher.getInstance("AES");
		aesCipher.init(Cipher.DECRYPT_MODE, aesKey);
		
		byte[] origMessage = aesCipher.doFinal(encryptedMessage);
		return origMessage;
		
	}
	
	public byte[] encryptCBC(String text, String key, byte[] iv) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
		
		byte[] message = text.getBytes();
		SecretKeySpec aesKey = new SecretKeySpec(key.getBytes(),"AES");
		// cbc mode
		// Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		
		//ctr mode
		Cipher aesCipher = Cipher.getInstance("AES/CTR/NoPadding");
		aesCipher.init(Cipher.ENCRYPT_MODE,aesKey,ivParameterSpec);
		
		byte[] encryptedMessage = aesCipher.doFinal(message);
		return encryptedMessage;
	}
	
	public byte[] decryptCBC(byte[] text, String key, byte[] iv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
		
		byte[] encryptedMessage = text;
		SecretKeySpec aesKey = new SecretKeySpec(key.getBytes(),"AES");
		
		//cbc mode
		// Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		
		//ctr mode
		Cipher aesCipher = Cipher.getInstance("AES/CTR/NoPadding");
		aesCipher.init(Cipher.DECRYPT_MODE, aesKey, ivParameterSpec);
		
		byte[] origMessage = aesCipher.doFinal(encryptedMessage);
		return origMessage;
		
	}

}
