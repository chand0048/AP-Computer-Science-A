package unit2;

import java.lang.Math;

public class Lab02e 
{
	
	public double circleArea(double radius)
	{
		double area = radius * Math.PI;
		return area;
	}
	public static void main(String[] args) 
	{
		Lab02e circle = new Lab02e();
		System.out.printf("The area is: %.4f\n\n", circle.circleArea(7.5));
		System.out.printf("The area is: %.4f\n\n", circle.circleArea(10));
		System.out.printf("The area is: %.4f\n\n", circle.circleArea(72.534));
		System.out.printf("The area is: %.4f\n\n", circle.circleArea(55));
		System.out.printf("The area is: %.4f\n\n", circle.circleArea(101));
		System.out.printf("The area is: %.4f\n\n", circle.circleArea(99.952));
		
		
		
		


	}

}
