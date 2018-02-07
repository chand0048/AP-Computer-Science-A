package unit3;

import java.util.Scanner;


public class Lab03c 
{
	private double a, b, c;
	
	public Lab03c()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a: ");
		a = keyboard.nextDouble();
		
		System.out.print("Enter b: ");
		b = keyboard.nextDouble();
		
		System.out.print("Enter c: ");
		c = keyboard.nextDouble();
		
		keyboard.close();
	}
	
	public void quadraticEquation() 
	{
		double rootOne, rootTwo;
		rootOne = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
		rootTwo = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
		
		System.out.printf("\n\nrootOne = %.2f\n", rootOne);
		System.out.printf("rootTwo = %.2f", rootTwo);
	}
	public static void main(String[] args)
	{
		Lab03c run = new Lab03c();
		run.quadraticEquation();

	}

}
