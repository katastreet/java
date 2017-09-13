package test;

public class SymmetricRC4 implements Cipher{

	@Override
	public String encrypt(String text, String key) {
		int i = 0;
		int j = 0;
		int[] s = new int[256];
		String result = new String();
		
		s = initKeystream(key.toCharArray());
		for(char c: text.toCharArray()) {
			i = (i + 1) % 256;
			j = (j + 1) % 256; 
			swap(s,i,j);
			result += (char)((int)c ^ s[(s[i]+s[j]) % 256]);	
		}
		return result;
		
	}

	@Override
	public String decrypt(String text, String key) {
		return encrypt(text, key);
	}
	
	private int[] initKeystream(char[] key) {
		int[] s = new int[256];
		int i = 0;
		int j = 0;
		// initialization
		for(i=0; i <= 255; i++) {
			s[i] = i;
		}
		
		j=0;
		
		for(i=0; i<=255; i++) {
			j = (j+ s[i] + (int)key[i % key.length]) % 256;
			swap(s,i,j);
		}
		return s;
	}
	private void swap(int[] s, int i, int j) {
		int temp = s[i];
		s[i] = s[j];
		s[j] = temp;
		
	}

}
