package unit8;

import java.util.Scanner;

public class Lab14d
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		//add test cases
		System.out.print("Length: ");
		Grades gradebook1 = new Grades(keyboard.nextInt());
		System.out.println(gradebook1);
		
		System.out.print("Length: ");
		Grades gradebook2 = new Grades(keyboard.nextInt());
		System.out.println(gradebook2);
		
		System.out.print("Length: ");
		Grades gradebook3 = new Grades(keyboard.nextInt());
		System.out.println(gradebook3);
		
		System.out.print("Length: ");
		Grades gradebook4 = new Grades(keyboard.nextInt());
		System.out.println(gradebook4);
	}
}
