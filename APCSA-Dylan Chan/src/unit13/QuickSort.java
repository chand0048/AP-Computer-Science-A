package unit13;

import static java.lang.System.*;
import java.util.Arrays;		//use Arrays.toString() to help print out the array

public class QuickSort
{
	private static int passCount;

	public static void quickSort(Comparable[] list)
	{
		int low = 0, high = list.length - 1;
		passCount = 0;
		quickSort(list, low, high);
		out.println();
	}


	private static void quickSort(Comparable[] list, int low, int high)
	{
		if (low < high)
		{
			
			int split = partition(list, low, high);
			quickSort(list, low, split);
			quickSort(list, (split + 1), high);
		}
	}

	private static int partition(Comparable[] list, int low, int high)
	{
		Comparable pivot = list[low];
		int bot = low - 1, top = high + 1;
		
		while (bot < top)
		{
			while (list[--top].compareTo(pivot) > 0);
			while (list[++bot].compareTo(pivot) < 0);
			if (bot >= top)
			{
				out.printf("pass %s %s\n", passCount, Arrays.toString(list));
				passCount++;
				return top;
			}
			Comparable temp = list[bot];
			list[bot] = list[top];
			list[top] = temp;
		}
		return 0;
	}
}
