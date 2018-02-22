package unit8;

import java.lang.System;
import java.lang.Math;
import java.util.Scanner;

public class Grades
{
	Scanner keyboard = new Scanner(System.in);
	//instance variables
	double[] gradeArray;
	int length;

	//constructor
	public Grades(int length)
	{
		
		gradeArray = new double[length];
		this.length = length;
		
		System.out.printf("Grades (list all %s grades with spaces in between): \n", length);
		for (int index = 0; index < length; index++)
		{
			gradeArray[index] = keyboard.nextDouble();
		}
		
	}


	//set method
	public void setArray(int length)
	{
		
		gradeArray = new double[length];
		this.length = length;
		
		System.out.printf("Grades (list all %s grades with spaces in between): \n", length);
		for (int index = 0; index < length; index++)
		{
			gradeArray[index] = keyboard.nextDouble();
		}
		
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
