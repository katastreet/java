package cryptoTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;


public class DigitalEnvelop {
	public static final String output_file = "encrypted.txt";
	
	public String encrypt(String fileName,  PublicKey pubKey) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, FileNotFoundException {
		SecretKey aesKey = AESCipher.AESKeyGenerator();
		IvParameterSpec ivParameterSpec = AESCipher.generateIV(16);
		
		//encrypt the file
		//@SuppressWarnings("resource")
//		String content = new Scanner(new File(DigitalEnvelop.class.getClassLoader().getResource(fileName).getPath())).useDelimiter("\\Z").next();
		
		@SuppressWarnings("resource")
		String content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();

		AESCipher aesCipher = new AESCipher();
		byte[] encrypted = aesCipher.encrypt(content, aesKey, ivParameterSpec);
		System.out.println(encrypted);
		
		//encrypt the generated aes key
		RSACipher rsaCipher = new RSACipher();
		
		@SuppressWarnings("restriction")
		String aesKeyRSAEncoded = new sun.misc.BASE64Encoder().encode(aesKey.getEncoded());
		
		byte[] aesKeyEncryptedByRSA = rsaCipher.encrypt(aesKeyRSAEncoded, pubKey);
		
		@SuppressWarnings("restriction")
		String json = Json.createObjectBuilder().add("password", new sun.misc.BASE64Encoder().encode(aesKeyEncryptedByRSA)).add("IV",new sun.misc.BASE64Encoder().encode(ivParameterSpec.getIV())).add("encrypted",new sun.misc.BASE64Encoder().encode(encrypted)).build().toString();
		
		PrintWriter outFile = new PrintWriter(output_file);
		outFile.print(json);
		outFile.close();		
		return output_file;
		
	}
	public String decrypt(String fileName, PrivateKey privateKey) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, IOException {
		@SuppressWarnings("resource")
		String content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
		JsonReader jsonReader = Json.createReader(new StringReader(content));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		
		RSACipher rsaCipher = new RSACipher();
		String encodedPassword = jsonObject.getString("password");
	
		@SuppressWarnings("restriction")
		byte[] decodedPassword = new sun.misc.BASE64Decoder().decodeBuffer(encodedPassword);
		byte[] aesKeyDecryptedByRSAencoded = rsaCipher.decrypt(decodedPassword, privateKey);
		@SuppressWarnings("restriction")
		byte[] aesKeyDecryptedByRSA = new sun.misc.BASE64Decoder().decodeBuffer(new String(aesKeyDecryptedByRSAencoded));
		
		AESCipher aesCipher = new AESCipher();
		
		
		@SuppressWarnings("restriction")
		byte[] decrypted = aesCipher.decrypt(new sun.misc.BASE64Decoder().decodeBuffer(jsonObject.getString("encrypted")),new SecretKeySpec(aesKeyDecryptedByRSA,"AES"), new IvParameterSpec(new sun.misc.BASE64Decoder().decodeBuffer(jsonObject.getString("IV"))));
		System.out.println(new String(decrypted));
		return null;
	}

}
