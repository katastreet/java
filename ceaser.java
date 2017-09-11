package test;

public class ceaser {
	private int key;
	ceaser(){
		
	}
	ceaser(int k){
		this.key = k;
	}
	public void setKey(int k) {
		this.key = k;
	}
	public String encrypt(String text){
		String result=new String();
		int a;
		for(char c : text.toCharArray()) {
		a = ((int)c);
		if(Character.isAlphabetic(c)) {
			a = a + key;
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
	public String decrypt(String text){
		String result=new String();
		int a;
		for(char c : text.toCharArray()) {
		a = ((int)c);
		if(Character.isAlphabetic(c)) {
			a = a- key;
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
		ceaser breakclass = new ceaser(0);
		String decypher = new String();
		for(int i = 0; i<26; i++) {
			breakclass.setKey(i);
			decypher = breakclass.decrypt(s);
			if(decypher.contains("http")){
				break;
			}
		}
		return decypher;
	}
	
	}
