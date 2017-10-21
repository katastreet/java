public class ECCipherTest {
    @Test
    public void test() throws Exception{
            KeyPair eccipherKey = ECCipher.generateKeyPair();
            String message ="hello world";
            ECCipher ecCipher = new ECCipher();
            byte[] encrypted  = ecCipher.encrypt(eccipherKey.getPublic(),message);
            byte[] decrypted = ecCipher.decrypt(eccipherKey.getPrivate(),encrypted);
            assertEquals(message, new String(decrypted));
    }
} 
