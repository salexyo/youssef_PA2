import java.util.Scanner;

public class BMICalculator 
{
	// Pseudocode:
	// This class calculates and returns a BMI value and category based on user input by:
	// 	- Ask for user to specify imperial or metric unit
	//	- Ask for the user to enter height and weight based on units
	// 	- Calculate BMI based on the height and weight entered, using the imperial
	//		or metric formula based of the unit they specified
	//	- Categorize the BMI score into one of four categories:
	// 		- Underweight (bmi <= 18.5)
	//		- Normal weight (18.5 < bmi <= 24.9)
	//		- Overweight (25 < bmi <= 29.9)
	//		- Obese (bmi >= 30)
	//	- Print the bmi score and category it falls under.
	
	private double weight;
	private double height;
	private double bmiValue;
	private String bmiCategory;
	private int unitChoice;
	private Scanner input;

	// The main method instantiates a BMICalculator object. It uses the object's
	// methods to read in user data, calculate the bmi based on that data,
	// and display the results along with the category for that bmi score.
	public static void main(String[] args) 
	{
	    BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();
	}
		
	
	// This function reads user data.
	// It asks for the unit type using readUnitType() and sends that
	// result to readMeasurementData().
	public void readUserData()
	{
		input = new Scanner(System.in);
		System.out.println("Welcome to the BMI Calculator!");

		this.unitChoice = readUnitType();
		
		readMeasurementData(this.unitChoice);		
	} 
	
	// This function asks the user to enter '1' for imperial unit or '2'
	// for metric units. It returns the result.
	private int readUnitType()
	{	
		System.out.println("Enter '1' for imperial units or '2' for metric units: ");
		int unitChoice = input.nextInt();
		
		// Continue to ask the user for their choice if they enter an incorrect value. 
		while (unitChoice != 1 && unitChoice != 2)
		{
			System.out.println("Please enter a correct value!");
			System.out.println("Enter '1' for imperial units or '2' for metric units: ");
			unitChoice = input.nextInt();
		}
		
		return unitChoice;
	}
	
	// Takes a user choice in and uses that to either call
	// readImperialData() or readMetricData().
	private void readMeasurementData(int unitChoice) 
	{			
		if (unitChoice == 1)
		{
			readImperialData();
		}
		else if (unitChoice == 2)
		{
			readMetricData();
		}
	}
	
	// Reads user data in as metric data.
	// If the user enters an incorrect value, the program exits
	// with exit code 0.
	private void readMetricData()
	{		
		System.out.println("Enter height in meters:");
		double height = input.nextInt();
		setHeight(height);
		
		if ( height <= 0 )
			System.exit(0);
		
		System.out.println("Enter weight in kilograms:");
		double weight = input.nextInt();
		setWeight(weight);
		
		if ( weight <= 0 )
			System.exit(0);
	}
	
	// Reads user data in as imperial data.
	// If the user enters an incorrect value, the program exits
	// with exit code 0.
	private void readImperialData()
	{		
		System.out.println("Enter height in inches:");
		double height = input.nextInt();
		setHeight(height);
		

		if ( height <= 0 )
			System.exit(0);
		
		System.out.println("Enter weight in pounds:");
		double weight = input.nextInt();
		setWeight(weight);
		
		if ( weight <= 0 )
			System.exit(0);
	}
	
	// Calculates the BMI based on the instance variables height and weight.
	// It sets the BMI score and BMI category instance variables accordingly.
	// It makes use of getBmi() and getBmiCategory() to do this.
	public void calculateBmi()
	{	
		this.bmiValue = getBmi(this.height, this.weight, this.unitChoice);
		this.bmiCategory = getBmiCategory(bmiValue);
	}
	
	// Prints the BMI score and BMI category to standard output.
	public void displayBmi()
	{		
		System.out.println("Your BMI is: " + this.bmiValue);
		System.out.println("Your BMI category is: " + this.bmiCategory);
	}
	
	// Calculates a BMI score based on height and weight that is passed to it.
	// A unit choice is also passed to determine which formula to use (imperial or metric).
	public double getBmi(double height, double weight, int unitChoice)
	{
		double bmiValue = 0;
		if ( unitChoice == 1)
		{
			bmiValue = (703 * weight)/(height * height);
			
		}
		
		if (unitChoice == 2)
		{
			bmiValue = (weight)/(height * height);
		}
		
		return bmiValue;
	}
	
	// Based on the bmi value passed to this function, it will return a
	// string that corresponds to the category that bmi falls under.
	public String getBmiCategory(double bmiValue)
	{
		String bmiCategory;
				
		if (bmiValue <= 18.5)
		{
			bmiCategory = "Underweight";
		}	
		else if (bmiValue >= 18.5 && bmiValue <= 24.9)
		{
			bmiCategory = "Normal weight";
		}
		else if (bmiValue >= 25 && bmiValue <= 29.9)
		{
			bmiCategory = "Overweight";
		}
		else
		{
			bmiCategory = "Obese";
		}	
				
		return bmiCategory;
	}
	
	public double getHeight()
	{
		return this.height;
	}
	
	private void setHeight(double height) 
	{
		this.height = height;
	}
	
	public double getWeight()
	{
		return this.weight;
	}	
	
	private void setWeight(double weight)
	{
		this.weight = weight;
	}

}
