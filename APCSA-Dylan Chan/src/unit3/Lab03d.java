package unit3;

import java.util.Scanner;

public class Lab03d
{
	private double x1, x2, y1, y2;
	
	public Lab03d()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter X1: ");
		x1 = keyboard.nextDouble();
		
		System.out.print("Enter Y1: ");
		y1 = keyboard.nextDouble();
		
		System.out.print("Enter X2: ");
		x2 = keyboard.nextDouble();
		
		System.out.print("Enter Y2: ");
		y2 = keyboard.nextDouble();
		
		keyboard.close();
	}
	
	public void distanceCalc()
	{
		double distance;
		
		distance = Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0));
		System.out.printf("distance == %.3f", distance);
	}
	
	public static void main(String[] args)
	{
		Lab03d run = new Lab03d();
		run.distanceCalc();
	}

}
