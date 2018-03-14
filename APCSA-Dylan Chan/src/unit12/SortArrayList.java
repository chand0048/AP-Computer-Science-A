package unit12;

import java.util.ArrayList;

public class SortArrayList
{
	public static void sort(ArrayList<Integer> list)
	{		
		for (int index = 0; index < list.size(); index++)
		{
			int location = index;
			for (int psn = index; psn < list.size(); psn++)
			{
				if (list.get(psn) < list.get(location))
				{
					location = psn;
				}
			}
			
			int temp = list.get(index);
			
			list.set(index, list.get(location));
			list.set(location, temp);
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> test = new ArrayList<Integer>();
		
		for (int counter = 0; counter < 5; counter++)
		{
			test.add((int) Math.ceil(Math.random() * 100));
		}
		
		sort(test);
		
		for (int num: test)
		{
			System.out.println(num);
		}
	}
}
