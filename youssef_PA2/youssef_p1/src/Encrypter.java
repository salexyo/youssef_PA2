
public class Encrypter
{
	// Pseudocode:
	// This function extracts 4 digits from a 4-digit number.
	// Then, it encrypts each digit: digit = (digit + 7) % 10.
	// Next, it swaps the first and third digit.
	// Next, it swaps the second and fourth digit.
	// Finally it reconstucts the new digits into their integer equivalent.
	// This value is returned.
	public int encrypt(int n)
	{	
		// Extract each digit from the number.
		int first = (n % 10); 
		int second = (n % 100)/10;
		int third = (n % 1000)/100;
		int fourth = (n % 10000)/1000;
		    
		// Add 7 to each digit, then mod by 10.
		first = (first+7) % 10;
		second = (second+7) % 10;
		third = (third +7) % 10;
		fourth = (fourth+7) % 10;
		
		// Swap the first and third digit.
		int temp = first; 
		first = third; 
		third = temp; 
		
		// Swap the second and fourth digit.
		temp = second;
		second = fourth;
		fourth = temp;
		     
		// Recompose the actual integer the digits represent.
		int number = (first * 1)+(second*10)+(third*100)+(fourth*1000);
		
		return number;
	}	
} 