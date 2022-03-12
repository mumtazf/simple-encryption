package encryption;

public class Scytale implements EncryptionDecryption{
	
//empty cells are not exactly empty those are spaces, so you need to work on that
	
	@Override
	/* @encryptWithKey method takes in the text from the user and the key
	 * and returns the encrypted string
	 * */
	public String encryptWithKey(String plainText, int key) {
		
		//String to hold the value of the encrypted string
		String result ="";
		
		//calculating the length of the string
		int strLength = plainText.length();
		
		//variables to hold the index value, number of rows and column in the matrix
		int k = 0, row, column; 
		
		row = (int) Math.ceil((double) strLength/key);
		column = key;

		//char matrix to hold the value of individual characters in the string
		char encryptedString[][] = new char[row][column];

		//Encrypting the plain text into the matrix
		for(int i = 0; i<row; i++) {
			for(int j = 0; j < column; j++){
				if(k < plainText.length()) {
					encryptedString[i][j] = plainText.charAt(k);
					k++;
				}
				else
					encryptedString[i][j]= ' ';
			}
		}
		
		//Encoding the string through Scytale by adding the characters column-wise
		for(int i = 0; i<column; i++)
			for(int j = 0; j<row; j++) {
				result+= encryptedString[j][i]; //the error is here 
				//because if j > i at some places we are going to have null.
			}
		
	return result;
	
	}

	@Override
	/* @decryptWithKey method takes in the encrypted text from the user and the key
	 * and returns the plain string
	 * */
	public String decryptWithKey(String plainText, int key) {
		
		//String to hold the value of the decrypted string
		String result ="";
		
		//calculating the length of the string
		int strLength = plainText.length();
		
		//variables to hold the index value, number of rows and column in the matrix
		int k = 0, row, column; 
		
		//The rows are calculated by rounding off the result of dividing the length of the string by the key to the next highest integer.
		row = (int) Math.ceil((double)strLength/key);
		column = key;

		//char matrix to hold the value of individual characters in the string
		char encryptedString[][] = new char[row][column];
		
		//Encrypting the encrypted text into the matrix
		for(int j = 0; j<column; j++)
			for(int i = 0; i < row; i++)
				if(k < plainText.length()) {
						encryptedString[i][j] = plainText.charAt(k);
						k++;
				}
		
		//Decrypting the text from the matrix by adding the characters row-wise
			for(int i = 0; i < row; i++)
				for(int j = 0; j<column; j++)
						result+= encryptedString[i][j]; 
		
		return result;
	}
}
