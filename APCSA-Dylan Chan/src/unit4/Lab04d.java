package unit4;

import java.util.Scanner;

public class Lab04d 
{
	

	
	public String[] fillArray()
	{
		Scanner keyboard = new Scanner(System.in);
		
		String[] array;
		array = new String[5];
		
		for (int counter = 0; counter <= 4; counter++)
		{
			System.out.printf("Name %s: ", counter + 1);
			array[counter] = keyboard.nextLine();
		}
		
		keyboard.close();
		
		return array;
	}
	
	public String getFirstName(String fullName)
	{

		return fullName.substring(0, fullName.indexOf(" "));
	}
	
	public String getLastName(String fullName)
	{
		return fullName.substring(fullName.indexOf(" ") + 1);
	}
	
	public static void main(String[] args)
	{
		Lab04d nameSeperator = new Lab04d();
		
		String[] nameArray = nameSeperator.fillArray();

		
		for (int counter = 0; counter <= 4; counter++)
		{
			System.out.println();
			System.out.println(nameSeperator.getFirstName(nameArray[counter]));
			System.out.println(nameSeperator.getLastName(nameArray[counter]));
			System.out.println(nameArray[counter]);
		}
	}
}
