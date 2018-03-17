package unit13;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSort
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = 0;

		do
		{
			count++;
			number /= 10;
		} while (number / 10 > 0);

		return count;
	}
	
	public static int[] getSortedDigitArray(int number)
	{
		int[] sorted = new int[getNumDigits(number)];
		
		int tempNum = number;
		
		for (int index = 0; index < getNumDigits(number); index++)
		{
			sorted[index] = tempNum % 10;
			tempNum /= 10;
		}
		
		Arrays.sort(sorted);
		
		return sorted;
	}
}
