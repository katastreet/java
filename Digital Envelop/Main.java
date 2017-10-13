package cryptoTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


public class Main {
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidAlgorithmParameterException, IOException { 
		KeyPair keyPair = RSACipher.KeyPairGeneration(2048);
		
		DigitalEnvelop digitalEnvelop = new DigitalEnvelop();
		String fileName = digitalEnvelop.encrypt("gutenberg.txt", keyPair.getPublic());
		
		digitalEnvelop.decrypt(fileName, keyPair.getPrivate());
		

		
	}

}
