package unit4;

import java.util.Scanner;

public class Lab04d 
{
	String[] namesArray = new String[5];
	
	
	public Lab04d()
	{
		Scanner keyboard = new Scanner(System.in);
		
		for (int counter = 0; counter <= 4; counter++)
		{
			System.out.printf("Name %f: ", counter);
			namesArray[counter] = keyboard.nextLine();
		}
		
		keyboard.close();
	}
	
	public String getFirstName(String fullName)
	{

		return fullName.substring(0, fullName.indexOf(" "));
	}
	
	public String getLastName(String fullName)
	{
		return fullName.substring(fullName.indexOf(" "));
	}
	
	public static void main(String[] args)
	{
		Lab04d nameSeperator = new Lab04d();
		
		for (int counter = 0; counter <= 4; counter++)
		{
			
		}
	}
}
