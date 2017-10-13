package cryptoTest;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESCipher {
	public static final String ALPHA_NUM = "abcdefghijklmnopqrstuvwxyz0123456789";
	
	public static SecretKey AESKeyGenerator() throws NoSuchAlgorithmException {
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		//SecureRandom random = new SecureRandom(); // secure random 
		//keyGen.init(random); 
		return keyGen.generateKey();
	
	}
	
	public static IvParameterSpec generateIV(int ivsize) {
		int ivSize  = 16;
		byte[] iv = new byte[ivSize];
		SecureRandom random = new SecureRandom();
		random.nextBytes(iv);
		return new IvParameterSpec(iv);
		
	}
	
	public byte[] encrypt(String text, SecretKey aesKey, IvParameterSpec ivParameterSpec) throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {
		
		byte[] message = text.getBytes();
		
		Cipher aesCipher = Cipher.getInstance("AES/CTR/NoPadding");
		aesCipher.init(Cipher.ENCRYPT_MODE,aesKey,ivParameterSpec);
		
		byte[] encryptedMessage = aesCipher.doFinal(message);
		return encryptedMessage;
	}
	public byte[] decrypt(byte[] text, SecretKey aesKey, IvParameterSpec ivParameterSpec) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {		
		byte[] encryptedMessage = text;
		
		Cipher aesCipher = Cipher.getInstance("AES/CTR/NoPadding");
		aesCipher.init(Cipher.DECRYPT_MODE, aesKey, ivParameterSpec);
		
		byte[] origMessage = aesCipher.doFinal(encryptedMessage);
		return origMessage;
		
	}

}
