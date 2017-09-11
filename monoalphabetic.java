package test;

public class monoalphabetic {
	private String cipher;
	private String plain="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	monoalphabetic(String s){
		this.cipher = s;
	}
	public void setCipher(String c) {
		this.cipher=c;
	}
	public String encrypt(String text) {
		String result = new String();
		for(char c: text.toCharArray()) {
			result += cipher.toCharArray()[plain.indexOf(c)];
		}
		return result;
		
	}
	public String decrypt(String text) {
		String result = new String();
		for(char c: text.toCharArray()) {
			result += plain.toCharArray()[cipher.indexOf(c)];
		}
		return result;
		
	}
	

}
