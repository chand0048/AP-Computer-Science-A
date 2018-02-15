package unit5;

import static java.lang.System.*;
import java.util.Scanner;

public class Lab05d
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("This program will cycle five times.\n");
		
		for (int counter = 1; counter <= 5; counter++)
		{
			out.print("Enter a letter :: ");
			char letter = keyboard.next().charAt(0);
		
		
			CharacterAnalyzer test = new CharacterAnalyzer(letter);
			out.println(test);   
		}
		
		
		
		
		
		
		
		
		

	}
}