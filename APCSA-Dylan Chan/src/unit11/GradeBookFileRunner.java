package unit11;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.io.File;

public class GradeBookFileRunner
{
   public static void main( String args[] ) throws Exception
   {
		out.println("Welcome to the Class Stats program!");
		
		try
		{
			Scanner file = new Scanner(new File(System.getProperty("user.dir") + "\\src\\unit11\\gradebook.dat"));
			
			//out.print("What is the name of this class? ");
			String className = file.nextLine();
			
			//out.print("\n\nHow many students are in this class? ");
			int numberOfStudents = file.nextInt();
			file.nextLine();
			
			Class classroom = new Class(className, numberOfStudents);
			
			
			for (int stuNum = 0; stuNum < numberOfStudents; stuNum++)
			{
				//out.print("\n\nEnter the name of student " + (stuNum + 1) + " : ");
				String stuName = file.nextLine();
				
				//out.print("Use the format x - grades ( 2 - 100 100) : ");
				
				classroom.addStudent(stuNum, new Student(stuName, file.nextLine()));
			}
			
			out.println("\n\n" + classroom);
			
			out.println("Failure List = " + classroom.getFailureList(70));	
			out.println("Highest Average = " + classroom.getStudentWithHighestAverage());
			out.println("Lowest Average = " + classroom.getStudentWithLowestAverage());
									
			out.println(String.format("Class Average = %.2f",classroom.getClassAverage()));
		}
		catch (Exception e)
		{
			out.println(e);
		}
   }
}
