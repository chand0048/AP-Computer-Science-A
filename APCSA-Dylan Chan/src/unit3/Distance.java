package unit3;

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Distance
{
	private int xOne,yOne,xTwo,yTwo;
	private double distance;

	public Distance()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter X1: ");
		xOne = keyboard.nextInt();
		
		System.out.print("Enter Y1: ");
		yOne = keyboard.nextInt();

		System.out.print("Enter X2: ");
		xTwo = keyboard.nextInt();
		
		System.out.print("Enter Y2: ");
		yTwo = keyboard.nextInt();
	}

	public Distance(int x1, int y1, int x2, int y2)
	{
		xOne = x1;
		yOne = y1;
		yTwo = x2;
		yTwo = y2;
		System.out.println("Enter X1: " + xOne);
		System.out.println("Enter Y1: " + yOne);
		System.out.println("Enter X2: " + xTwo);
		System.out.println("Enter X2: " + yTwo);
	}

	public void setCoordinates(int x1, int y1, int x2, int y2)
	{
		xOne = x1;
		yOne = y1;
		yTwo = x2;
		yTwo = y2;
		System.out.println("Enter X1: " + xOne);
		System.out.println("Enter Y1: " + yOne);
		System.out.println("Enter X2: " + xTwo);
		System.out.println("Enter X2: " + yTwo);
	}

	public void calcDistance()
	{
		distance = Math.sqrt(Math.pow(xTwo - xOne, 2.0) + Math.pow(yTwo - yOne, 2.0));
	}

	public void print( )
	{
		System.out.printf("distance == %.3f\n\n", distance);
	}
}