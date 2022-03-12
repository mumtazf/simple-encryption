package encryption;

public class ReverseCaesar implements EncryptionDecryption {

	@Override
	public String encryptWithKey(String plainText, int key) {
		
		String result = "";
		int num = 0;
		
		//Traversing the string to create reverse string
		String reversedString = "";

		for(int i = plainText.length()-1; i>=0; i--)
			reversedString += plainText.charAt(i);
		
		//I should consider the keys from 0 to 32 and create exceptions for them.
		//assume that the characters are printable 
		for(int i = 0; i<reversedString.length(); i++)
		{	
			//Finding the ASCII value of the character
			 num = (int)(reversedString.charAt(i));
			 
			 if(num < 255 - key) {
				 result += (char) (num + key);
			 }

			 else {
				 //not exceeding from 255 ASCII values to prevent an error
					result += (char) (num + key - 256); 
				 } 
		 }
		return result;
	}

	@Override
	public String decryptWithKey(String plainText, int key) {
		String result = "";
		int num = 0;
		
		//Traversing the string to create reverse string
			String reversedString = "";
		
			for(int i = plainText.length()-1; i>=0; i--)
				reversedString += plainText.charAt(i);
		
		for(int i = 0; i<reversedString.length(); i++) {
			
			//Finding the ASCII value of the character
			 num = (int)(reversedString.charAt(i));
			 
			 if(num < key) {
				 //if the ASCII value of the character is smaller than the key, then it would
				 //result in a negative number - which is incorrect
				 result += (char) (256 - key);
			 }

			 else {
					result += (char) (num - key); 
				 } 
			 }
		return result;
		}	
	}

