package unit8;

import java.lang.System;
import java.lang.Double;
import java.lang.Math;
import java.util.Scanner;

public class Grades
{
	Scanner keyboard = new Scanner(System.in);
	//instance variables
	double[] gradeArray;
	int length;

	//constructor
	public Grades(int length, String grades)
	{
		
		double[] temp = new double[length];
		this.length = length;
		String tempString = grades.trim();
		
		for (int index = 0; index < length; index++)
		{
		  if (tempString.indexOf(" ") >= 0)
		  {
		    double cast = Double.parseDouble(tempString.substring(0, tempString.indexOf(" ", 0)));
			  temp[index] = cast;
			  tempString = tempString.substring(tempString.indexOf(" ") + 1);
		  }
		  else
		  {
		    double cast = Double.parseDouble(tempString);
		    temp[index] = cast;
		  }
		}
		gradeArray = temp;
		
	}


	//set method
	public void setGrades(int length, String grades)
	{
		
		double[] temp = new double[length];
		this.length = length;
		String tempString = grades.trim();
		
		for (int index = 0; index < length; index++)
		{
		  if (tempString.indexOf(" ") >= 0)
		  {
		    double cast = Double.parseDouble(tempString.substring(0, tempString.indexOf(" ", 0)));
			  temp[index] = cast;
			  tempString = tempString.substring(tempString.indexOf(" ") + 1);
		  }
		  else
		  {
		    double cast = Double.parseDouble(tempString);
		    temp[index] = cast;
		  }
		}
		gradeArray = temp;
		
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
