package unit11;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.util.ArrayList;

public class GradeBookRunner
{
   public static void main( String args[] )
   {
		out.println("Welcome to the Class Stats program!\n");
		
		Scanner keyboard = new Scanner(System.in);
		
		ArrayList<Class> gradebook = new ArrayList<Class>();
		
		out.print("How many classes do you have? ");
		int numClasses = keyboard.nextInt();
		keyboard.nextLine();
		
		for (int counter = 0; counter < numClasses; counter++)
		{
			out.print("\n\nWhat is the name of class " + (counter + 1) + "? ");
			String className = keyboard.nextLine();
			
			out.print("\nHow many students are in this class? ");
			int numberOfStudents = keyboard.nextInt();
			keyboard.nextLine();
			
			Class classroom = new Class(className, numberOfStudents);
			
			for (int stuNum = 0; stuNum < numberOfStudents; stuNum++)
			{
				out.print("\nEnter the name of student " + (stuNum + 1) + " : ");
				String stuName = keyboard.nextLine();
				
				out.print("Use the format x - grades ( 2 - 100 100) : ");
				
				classroom.addStudent(stuNum, new Student(stuName, keyboard.nextLine()));
			}
			
			gradebook.add(classroom);
		}
		
		for (Class room: gradebook)
		{
			out.println("\n\n" + room);
			
			out.println("Failure List = " + room.getFailureList(70.0));	
			out.println("Highest Average = " + room.getStudentWithHighestAverage());
			out.println("Lowest Average = " + room.getStudentWithLowestAverage());
									
			out.println(String.format("Class Average = %.2f\n\n",room.getClassAverage()));
		}
		
		
   }
}
