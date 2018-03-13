package unit11;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Class
{
	private String name;
	private Student[] studentList;
	//private ArrayList<Student> studentList;
	
	public Class()
	{
		name = "";
		studentList = new Student[0];
		//studentList = new ArrayList<Student>();
	}
	
	public Class(String name, int stuCount)
	{
		this.name = name;
		studentList = new Student[stuCount];
		//studentList = new ArrayList<Student>();
	
	}
	
	public void addStudent(int stuNum, Student s)
	{
		studentList[stuNum] = s;
		//studentList.add(s);

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
		//classAverage /= studentList.size();

		return classAverage;
	}
	
	public double getStudentAverage(int stuNum)
	{
		return studentList[stuNum].getAverage();
		//return studentList.get(stuNum).getAverage();
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
		//return studentList.get(stuNum).getName();
	}

	public String getStudentWithHighestAverage()
	{
		double high = Double.MIN_VALUE;
		String hName = "";

		for (Student person: studentList)
		{
			if (person.getAverage() > high)
			{
				high = person.getAverage();
				hName = person.getName();
		}
		}
		
		//return hName;
		
		
		sort();
		
		return studentList[(studentList.length - 1)].getName();
		//return studentList.get(studentList.size() -1).getName();
	}

	public String getStudentWithLowestAverage()
	{
		double low = Double.MAX_VALUE;
		String hName ="";		
		
		for (Student person: studentList)
		{
			if (person.getAverage() < low)
			{
				low = person.getAverage();
				hName = person.getName();
			}
		}
		
		//return hName;
		
		
		sort();
		
		return studentList[0].getName();
		//return studentList.get(0).getName();
	}
	
	public void sort()
	{
		for (int index = 0; index < studentList.length; index++)
		//for (int index = 0; index < studentList.size(); index++)
		{
			Student compared = studentList[index];
			//Student compared = studentList.get(index);
			int indexOfChosen = index;
			
			for (int counter = index; counter < studentList.length; counter++)
			//for (int counter = index; counter < studentList.size(); counter++)
			{
				if (studentList[counter].compareTo(compared) == -1)
				//if (studentList.get(counter).compareTo(compared) == -1)
				{
					compared = studentList[counter];
					//compared = studentList.get(counter);
					indexOfChosen = counter;
				}
			}
			
			Student temp = studentList[index];
			studentList[index] = compared;
			studentList[indexOfChosen] = temp;
			
			//Student temp = studentList.get(index);
			//studentList.set(index, compared);
			//studentList.set(indexOfChosen, temp);
		}
	}
	
	public String getFailureList(double failingGrade)
	{
		String output = "";
		
		for (Student person: studentList)
		{
			if (person.getAverage() <= failingGrade)
			{
				output += person.getName() + ", ";
			}
		}
		
		if (output.length() == 0)
		{
			return "None";
		}
		else
		{
			output = output.substring(0, output.length() - 2);

			return output;
		}
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