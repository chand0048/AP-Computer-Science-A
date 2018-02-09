package unit2;

import java.util.Scanner;

public class Unit2_ReviewExercises 
{
	double velocity, acceleration;
	

	
	public void promptUser()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Velocity of Plane: ");
		velocity = keyboard.nextDouble();
		
		System.out.print("Accerleration of Plane: ");
		acceleration = keyboard.nextDouble();
		
		keyboard.close();
	}
	
	public double runwayLength()
	{
		promptUser();
		
		double length = Math.pow(velocity, 2) / (2 * acceleration);
		
		return length;
		
	}
	public static void main(String[] args) 
	{
		// Exercise 1 
		SavingsAccount savings = new SavingsAccount(1000, 10);
		
		System.out.printf("Original balance (w//o interest): $%.2f\n", savings.getBalance());
		System.out.printf("Interest: %.2f Percent\n", savings.getInterest());
		savings.addInterest();
		System.out.printf("Balance (w//interest): $%.2f\n\n", savings.getBalance());
		System.out.println();
		
		// Exercise 2
		Unit2_ReviewExercises run = new Unit2_ReviewExercises();
		
		System.out.printf("The minimum runway length is %.3f meters" ,run.runwayLength());
		
		
		

	}

}
