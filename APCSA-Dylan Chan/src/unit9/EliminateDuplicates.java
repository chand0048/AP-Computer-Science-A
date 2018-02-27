package unit9;

import java.util.Scanner;

public class EliminateDuplicates 
{
	public static int[] eliminateDuplicates(int[] list) 
	{
		int[] distinctIntArray = new int[list.length];
		boolean exists;
		
		for (int index = 0; index < list.length; index++)
		{
			exists = false;
			for (int distinct: distinctIntArray)
			{
				if (distinct == list[index])
				{
					exists = true;
				}
			}
			if (exists == false)
			{
				distinctIntArray[index] = list[index];
			}
		}
		
		int counter = 0;
		for (int item: distinctIntArray)
		{
			if (item != 0)
			{
				counter++;
			}
		}
		
		int[] simplifiedArray = new int[counter];
		
		counter = 0;
		for (int item: distinctIntArray)
		{
			if (item != 0)
			{
				simplifiedArray[counter] = item;
				counter++;
			}
		}
		return simplifiedArray;
	}
	
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		int[] inputArray = new int[10];
		
		System.out.print("Enter ten numbers: ");
		for (int counter = 0; counter < 10; counter++)
		{
			inputArray[counter] = keyboard.nextInt();
		}
		
		System.out.println("\nThe distinct numbers are: ");
		
		for (int item: eliminateDuplicates(inputArray))
		{
			System.out.print(item + " ");
		}
		
		keyboard.close();
	}
}
