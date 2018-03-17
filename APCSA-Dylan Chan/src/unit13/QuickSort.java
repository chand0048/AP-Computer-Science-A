package unit13;

import static java.lang.System.*;
import java.util.Arrays;		//use Arrays.toString() to help print out the array

public class QuickSort
{
	private static int passCount;

	public static void quickSort(Comparable[] list)
	{
		passCount = 0;
		
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		
		for (Comparable item: list)
		{
			if ((int) item < low)
			{
				low = (int) item;
			}
			if ((int) item > high)
			{
				high = (int) item;
			}
		}
		quickSort(list, low, high);
	}


	private static void quickSort(Comparable[] list, int low, int high)
	{
		if (low < high)
		{
			int split = partition(list, low, high);
			quickSort(list, low, split);
			quickSort(list, split + 1, high);
			out.printf("pass %s %s\n", passCount, Arrays.toString(list));
			passCount++;
		}
	}

	private static int partition(Comparable[] list, int low, int high)
	{
		Comparable pivot = list[0];
		int bot = low - 1, top = high + 1;
		
		while (bot < top)
		{
			while (list[top].compareTo(pivot) > 0)
			{
				top--;
			}
			while (list[bot].compareTo(pivot) < 0)
			{
				bot++;
			}
			if (bot >= top)
			{
				return top;
			}
			Comparable temp = list[bot];
			list[bot] = list[top];
			list[top] = temp;
		}
		













		return 0;
	}
}
