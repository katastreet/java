package test;

public class vigenere {
	private String atoz="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String key;
	vigenere(String k){
		this.key = k;
	}
	public void setKey(String s) {
		this.key = s;
	}
	public String encrypt(String text) {
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
	
	public String decrypt(String text) {
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
