package unit14;

import java.util.Scanner;

public class LargestArray 
{
	private int largestNum;
	
	public LargestArray(int[] array)
	{
		largestNum = Integer.MIN_VALUE;
		findLargest(array);
	}
	
	public void findLargest(int[] array)
	{
		if (largestNum < array[0])
		{
			largestNum = array[0];
		}
		
		if (array.length > 1)
		{
			int[] newArray = new int[array.length - 1];
			
			int index = 0;
			for (int counter = 1; counter < array.length; counter++)
			{
				newArray[index] = array[counter];
				index++;
			}
			
			findLargest(newArray);
		}
	}
	
	public int getlargestNum()
	{
		return largestNum;
	}
	
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		int[] testArray = new int[8];
		
		System.out.print("Please enter eight integers, with spaces in between them: ");
		for (int counter = 0; counter < 8; counter++)
		{
			testArray[counter] = keyboard.nextInt();
		}
		
		LargestArray test = new LargestArray(testArray);
		
		System.out.printf("\nThe largest number in the list was %s", test.getlargestNum());
	}
}
