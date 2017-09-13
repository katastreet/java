package test.session1;

public class Caesar implements Cipher{
	@Override
	public String encrypt(String text, String key) {
		int key1 = Integer.parseInt(key);
		String result=new String();
		int a;
		for(char c : text.toCharArray()) {
		a = ((int)c);
		if(Character.isAlphabetic(c)) {
			a = a + (int)key1;
		if(Character.isUpperCase(c) == true) {
			a = ((a - 65) % 26) + 65;
		}
		else {
			a = ((a - 97) % 26) + 97;
		}
		}
		result += (char) a;
		}
		return result;
	}
	@Override
	public String decrypt(String text, String key) {
		int key1 = Integer.parseInt(key);
		String result=new String();
		int a;
		for(char c : text.toCharArray()) {
		a = ((int)c);
		if(Character.isAlphabetic(c)) {
			a = a - key1;
		if(Character.isUpperCase(c) == true) {
			while(a<65) {
				a = (a - 65)+ 91;
			}
		}
		else {
			while(a<97) {
				a = (a - 97) + 123;
			}
		}
		}
		result += (char) a;
		}
		return result;
	}
	public String breakcypher(String s) {
		Caesar breakclass = new Caesar();
		String decypher = new String();
		for(int i = 0; i<26; i++) {
			decypher = breakclass.decrypt(s,String.valueOf(i));
			if(decypher.contains("http")){
				break;
			}
		}
		return decypher;
	}
	}
