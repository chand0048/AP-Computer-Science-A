package unit8;

import java.lang.System;
import java.lang.Math;
import java.util.Scanner;

public class Grades
{
	Scanner keyboard = new Scanner(System.in);
	//instance variables
	double[] gradeArray = new double[100];
	int length;

	//constructor
	public Grades()
	{
		double[] tempArray;
		
		System.out.print("Length: ");
		length = keyboard.nextInt();
		tempArray = new double[length];
		
		System.out.printf("Grades (list all %s grades with spaces in between): \n", length);
		for (int index = 0; index < length; index++)
		{
			tempArray[index] = keyboard.nextDouble();
		}
		
		gradeArray = tempArray;
	}


	//set method
	public void setArray()
	{
		double[] tempArray;
		
		System.out.print("Length: ");
		length = keyboard.nextInt();
		tempArray = new double[length];
		
		System.out.printf("Grades (list all %s grades with spaces in between): \n", length);
		for (int index = 0; index < length; index++)
		{
			tempArray[index] = keyboard.nextDouble();
		}
		
		gradeArray = tempArray;
	}


	private double getSum()
	{
		double sum=0.0;
		for (double item: gradeArray)
		{
			sum += item;
		}

		return sum;
	}

	public double getAverage()
	{
		double average = getSum() / length;
		return average;
	}


	//toString method
	public String toString()
	{
		String listing = "";
		for (int index = 0; index < length; index++)
		{
			listing += "grade " + index + ": " + gradeArray[index] + "\n";
		}
		
		listing += "\naverage: " + getAverage() + "\n\n\n";
		return listing;
	}

	
}
