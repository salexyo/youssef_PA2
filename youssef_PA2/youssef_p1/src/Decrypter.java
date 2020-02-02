
public class Decrypter 
{	
	// Pseudocode:
	// This function creates the original digit entered by user.
	// It extracts 4 digits from a 4-digit number.
	// Then, it decrypts each digit: digit = ((digit + 10)-7) % 10.
	// Next, it swaps the first and third digit back to their original place.
	// Next, it swaps the second and fourth digit back to their original place.
	// Finally it reconstucts the new digits into their integer equivalent.
	// This value is returned.
	public int decrypt(int n)
	{
		// Extract each digit from the number.
		int first = (n % 10); 
		int second = (n % 100)/10;
		int third = (n % 1000)/100;
		int fourth = (n % 10000)/1000;
					
		// Create the each original digit by adding 10, then subtracting 7, and then moding that number.
		first = ((first+10) - 7) % 10;
		second = ((second+10) - 7) % 10;
		third = ((third+10) - 7) % 10;
		fourth = ((fourth+10) - 7)  % 10;	
				
		// Swap the first and third digit back to their original place.
		int temp = first; 
		first = third; 
		third = temp;
		
		// Swap the second and fourth digit back to their original place.
		temp = second;
		second = fourth;
		fourth = temp;
				
		// Recompose the actual integer the digits represent.
		int number = (first * 1)+(second*10)+(third*100)+(fourth*1000);
		
		return number;
	}	
}
