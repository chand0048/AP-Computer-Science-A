package unit11;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Grades
{
	private Grade[] grades;
	
	public Grades()
	{
		setGrades("");
	}
	
	public Grades(String gradeList)
	{
		setGrades(gradeList);		
	}
	
	public void setGrades(String gradeList)
	{
		grades = new Grade[Integer.parseInt(gradeList.substring(0, 1))];
		
		int psn = 4;
		
		while (psn < gradeList.length())
		{
			for (int index = 0; index < grades.length; index++)
			{
				if (gradeList.indexOf(" ", psn) == -1)
				{
					Grade score = new Grade(Double.parseDouble(gradeList.substring(psn)));
					grades[index] = score;
					psn = gradeList.length();
				}
				else
				{
					Grade score = new Grade(Double.parseDouble(gradeList.substring(psn, gradeList.indexOf(" ", psn))));
					grades[index] = score;
					psn = gradeList.indexOf(" ", psn) + 1;
				}
			}
		}
	}
	
	public void setGrade(int spot, double grade)
	{
		Grade score = new Grade(grade);
		grades[spot] = score;
	}
	
	public double getSum()
	{
		double sum=0.0;

		for (Grade score: grades)
		{
			sum += score.getNumericGrade();
		}
		return sum;
	}
	
	public double getLowGrade()
	{
		double low = Double.MAX_VALUE;

		for (Grade score: grades)
		{
			if (score.getNumericGrade() < low)
			{
				low = score.getNumericGrade();
			}
		}

		return low;
	}
	
	public double getHighGrade()
	{
		double high = Double.MIN_VALUE;

		for (Grade score: grades)
		{
			if (score.getNumericGrade() > high)
			{
				high = score.getNumericGrade();
			}
		}

		return high;
	}
	
	public int getNumGrades()
	{
		return grades.length;
	}
	
	public String toString()
	{
		String output="";

		for (Grade score: grades)
		{
			output += score.getNumericGrade() + " ";
		}

		return output;
	}	
}
