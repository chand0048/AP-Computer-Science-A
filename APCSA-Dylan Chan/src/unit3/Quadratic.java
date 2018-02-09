package unit3;

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Quadratic
{
	private int a, b, c;
	private double rootOne;
	private double rootTwo;

	public Quadratic()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a: ");
		a = keyboard.nextInt();
		
		System.out.print("Enter b: ");
		b = keyboard.nextInt();
		
		System.out.print("Enter c: ");
		c = keyboard.nextInt();
		
		keyboard.close();
	}

	public Quadratic(int quadA, int quadB, int quadC)
	{
		a = quadA;
		b = quadB;
		c = quadC;
		System.out.printf("Enter a: %s\n", a);
		System.out.printf("Enter b: %s\n", b);
		System.out.printf("Enter c: %s\n", c);
	}

	public double setEquation1(int quadA, int quadB, int quadC)
	{
		return (-quadB + Math.sqrt(Math.pow(quadB, 2) - (4 * quadA * quadC))) / (2 * quadA);
 	}
	
	public double setEquation2(int quadA, int quadB, int quadC)
	{
		return (-quadB - Math.sqrt(Math.pow(quadB, 2) - (4 * quadA * quadC))) / (2 * quadA);
	}

	public void calcRoots( )
	{
		rootOne = setEquation1(a, b, c);
		rootTwo = setEquation2(a, b, c);

	}

	public void print( )
	{
		System.out.printf("\n\nrootOne = %.2f\n", rootOne);
		System.out.printf("rootTwo = %.2f\n\n\n\n", rootTwo);
	}
}
