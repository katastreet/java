package test.session3;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Main {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("TripleDES");
		SecretKey desKey = keyGenerator.generateKey(); 
		
		//OR use the password with 64 bit length
		//SecretKey desKey = new SecretKeySpec("password".getBytes(), "DES");
		
		//message
		byte[] message="Hello world!".getBytes();
		
		Cipher desCipher = Cipher.getInstance("TripleDES/ECB/PKCS5Padding");
		desCipher.init(Cipher.ENCRYPT_MODE,desKey);
		byte[] encryptedMessage = desCipher.doFinal(message);
		String encodedEncryptedMessage = new sun.misc.BASE64Encoder().encode(encryptedMessage);
		
		System.out.println("Encrypted message: "+ new String(encryptedMessage));
		System.out.println("Encrypted encoded message:" + encodedEncryptedMessage);
		
		
		desCipher.init(Cipher.DECRYPT_MODE,desKey);
		
		byte[] decodedEncryptedMessage = new sun.misc.BASE64Decoder().decodeBuffer(encodedEncryptedMessage);
		byte[] originalMessage = desCipher.doFinal(decodedEncryptedMessage);
		System.out.println("Decrypted message:" + new String(originalMessage));
		
		
		
	}

}
