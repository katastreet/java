package test.session1;

public class Vigenere implements Cipher{
	private String atoz="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	@Override
	public String encrypt(String text, String key) {
		String result = new String();
		char[] keyarray = key.toCharArray();
		int i = 0;
		char encrypted;
		for(char c: text.toCharArray()) {
			if(Character.isAlphabetic(c)) {
			encrypted = atoz.toCharArray()[(atoz.indexOf(c) + atoz.indexOf(keyarray[i]))%26];
			result += encrypted;
			}
			else {
				result += c;
			}
			i++;
			i= i % keyarray.length;
		}
		return result;
	}
	@Override
	public String decrypt(String text, String key) {
		String result = new String();
		char[] keyarray = key.toCharArray();
		int i = 0;
		char decrypted;
		for(char c: text.toCharArray()) {
			if(Character.isAlphabetic(c)) {
			decrypted = atoz.toCharArray()[(atoz.indexOf(c) - atoz.indexOf(keyarray[i]) + 26)%26];
			result += decrypted;
			}
			else {
				result += c;
			}
			i++;
			i= i % keyarray.length;
		}
		return result;
	}

}
