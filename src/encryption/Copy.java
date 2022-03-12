package encryption;

public class Copy implements EncryptionDecryption {

	@Override
	//Returns the plain text
	public String encryptWithKey(String plainText, int key) {
		return plainText;
	}

	@Override
	//Returns the plain text
	public String decryptWithKey(String plainText, int key) {
		return plainText;
	}
}
