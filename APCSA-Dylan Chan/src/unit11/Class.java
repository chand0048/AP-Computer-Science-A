package unit11;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.text.DecimalFormat;

public class Class
{
	private String name;
	private Student[] studentList;
	
	public Class()
	{
		name = "";
		studentList = new Student[0];
	}
	
	public Class(String name, int stuCount)
	{
		this.name = name;
		studentList = new Student[stuCount];
	
	}
	
	public void addStudent(int stuNum, Student s)
	{
		studentList[stuNum] = s;

	}
	
	public String getClassName()
	{
	   return name;	
	}
	
	public double getClassAverage()
	{
		double classAverage=0.0;
		
		for (Student person: studentList)
		{
			classAverage += person.getAverage();
		}
		classAverage /= studentList.length;

		return classAverage;
	}
	
	public double getStudentAverage(int stuNum)
	{
		return studentList[stuNum].getAverage();
	}

	public double getStudentAverage(String stuName)
	{
		for (Student person: studentList)
		{
			if (stuName.compareTo(person.getName()) == 0)
			{
				return person.getAverage();
			}
		}
		return 0.0;
	}
	
	public String getStudentName(int stuNum)
	{
		return studentList[stuNum].getName();
	}

	public String getStudentWithHighestAverage()
	{
		/*double high = Double.MIN_VALUE;
		**String hName = "";

		**for (Student person: studentList)
		**{
		**	if (person.getAverage() > high)
		**	{
		**		high = person.getAverage();
		**		hName = person.getName();
		**	}
		**}
		**
		**return hName;
		*/
		
		sort();
		
		return studentList[(studentList.length - 1)].getName();
	}

	public String getStudentWithLowestAverage()
	{
		/*double low = Double.MAX_VALUE;
		**String hName ="";		
		**
		**for (Student person: studentList)
		**{
		**	if (person.getAverage() < low)
		**	{
		**		low = person.getAverage();
		**		hName = person.getName();
		**	}
		**}
		**
		**return hName;
		*/
		
		sort();
		
		return studentList[0].getName();
	}
	
	public void sort()
	{
		for (int index = 0; index < studentList.length; index++)
		{
			Student compared = studentList[index];
			int indexOfChosen = index;
			
			for (int counter = index; counter < studentList.length; counter++)
			{
				if (studentList[counter].compareTo(compared) == -1)
				{
					compared = studentList[counter];
					indexOfChosen = counter;
				}
			}
			
			Student temp = studentList[index];
			studentList[index] = compared;
			studentList[indexOfChosen] = temp;
		}
	}
	
	public String getFailureList(double failingGrade)
	{
		String output="";
		
		for (Student person: studentList)
		{
			if (person.getAverage() <= failingGrade)
			{
				output += person.getName() + ", ";
			}
		}
		
		output = output.substring(0, output.length() - 2);

		return output;
	}
	
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("#.00");
		
		String output=""+getClassName()+"\n";
		
		for (Student person: studentList)
		{
			output += person + "\t" + df.format(person.getAverage()) + "\n";
		}

		return output;
	}  	
}