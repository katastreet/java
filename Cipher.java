package test;

public interface Cipher {
	public String encrypt(String text, String key);
	public String decrypt(String text, String key);
}
