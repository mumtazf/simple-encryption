package encryption;

//Interface to declare the structure of classes 
public interface EncryptionDecryption {
	
	/*@encryptWithKey() takes in plain text and key from the user 
	 * and returns the string of encrypted text.
	 */
	public String encryptWithKey(String plainText, int key);
	
	/*@decryptWithKey() takes in encoded text and key from the user 
	 * and returns the string of decrypted text.
	 */
	public String decryptWithKey(String plainText, int key);
}
