package unit13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Collections.*;

public class CountJournal 
{
	private ArrayList<Integer> numArray;
	public CountJournal()
	{
		numArray = new ArrayList<Integer>();
		
		for (int counter = 0; counter < 100; counter++)
		{
			numArray.add((int) Math.ceil((Math.random() * 99) + 1));
		}
	}
	
	public long linearSearch()
	{
		long time = System.nanoTime();
		
		ArrayList<Integer> instanceArray = new ArrayList<Integer>();
		
		for (int counter = 1; counter <= 100; counter++)
		{
			int count = 0;
			
			for (int num: numArray)
			{
				if (num == counter)
				{
					count++;
				}
			}
			
			instanceArray.add(count);
		}
		
		return System.nanoTime() - time;
	}
	
	public long binarySearch()
	{
		long time = System.nanoTime();
		
		ArrayList<Integer> instanceArray = new ArrayList<Integer>();
		
		Collections.sort(numArray);
		
		for (int counter = 1; counter <= 100; counter++)
		{
			int count = 0;
			
			ArrayList<Integer> tempArray = numArray;
			
			while (Collections.binarySearch(tempArray, counter) >= 0)
			{
				count++;
				tempArray.remove(Collections.binarySearch(tempArray, counter));
			}
			instanceArray.add(count);
			
		}
		return System.nanoTime() - time;
	}
	
	public String toString()
	{
		return numArray.toString() + "\n" + linearSearch() + " nanoseconds\n" + binarySearch() + " nanoseconds";
	}
	
	public static void main(String[] args)
	{
		CountJournal test = new CountJournal();
		
		System.out.println(test);
	}
}
