
import java.util.Scanner;


public class Application 
{
	// Pseudocode:
	// The Application class contains a main method that:
	//	- Asks the user for input.
	//	- Encrypts that input.
	//	- Prints the encrypted number.
	//	- Decrypts the encrypted number back to its original form.
	//	- Prints the decrypted number.
	
	public static void main(String[] args)
	{   
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int n = input.nextInt();
		
		Encrypter encrypter = new Encrypter();
		int encryptedNum = encrypter.encrypt(n);

		System.out.println("Here is the encrypted number: " + encryptedNum);
		
		Decrypter decrypter = new Decrypter();
		int decryptedNum = decrypter.decrypt(encryptedNum);
		
		System.out.println("Here is the decrypted number: " + decryptedNum);
		input.close();
	}
}
