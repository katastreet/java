package test.session1;

public class MonoAlphabetic implements Cipher{
	private String plain="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	@Override
	public String encrypt(String text, String key) {
		String result = new String();
		for(char c: text.toCharArray()) {
			result += key.toCharArray()[plain.indexOf(c)];
		}
		return result;
		
	}
	@Override
	public String decrypt(String text, String key) {
		String result = new String();
		for(char c: text.toCharArray()) {
			result += plain.toCharArray()[key.indexOf(c)];
		}
		return result;
	}
	

}
