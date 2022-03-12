package encryption;


public class Caesar implements EncryptionDecryption {

	@Override
	/* @encryptWithKey() takes in plain text from the user and asks them for a key.
	 * It encrypts each character by increasing its ASCII value by the key provided by user.
	 * */
	public String encryptWithKey(String plainText, int key) {
		
		String result = "";
		int num = 0;
		
		//I should consider the keys from 0 to 32 and create exceptions for them.
		//assume that the characters are printable 
		for(int i = 0; i<plainText.length(); i++)
		{
			//Finding the ASCII value of the character
			 num = (int)(plainText.charAt(i));
			 
			 if(num < 255 - key) {
			//incrementing the ASCII value by key
				 result += (char) (num + key);
			 }

			 else {
			//If the ASCII value of the character is greater than 254, then we prevent error by
			//subtracting 256 from the ASCII value
					result += (char) (num + key - 256); 
				 } 
		 }
		
		return result;
	}
	
	
	/* @decryptWithKey() takes in encrypted text from the user and asks them for a key.
	 * It encrypts each character by decreasing its ASCII value by the key provided by user.
	 * */
	@Override
	public String decryptWithKey(String plainText, int key) {
		String result = "";
		int num = 0;
		
		for(int i = 0; i<plainText.length(); i++)
		{
			//Finding the ASCII value of the character
			 num = (int)(plainText.charAt(i));
			 
			 //if the ASCII value of the character is smaller than the key, then it would
			 //result in a negative number - which is incorrect
			 if(num < key) {
				 result += (char) (256 - key);
			 }

			 else {
					result += (char) (num - key); 
				 } 
			 }
		
		return result;
		}	
	}
	
	


