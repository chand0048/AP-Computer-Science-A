package unit13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.lang.System.*;

class InsertionSort
{
	private ArrayList<String> list;

	public InsertionSort()
	{
		list = new ArrayList<String>();
	}

	//modfiers
	public void add( String  word)
	{
		int loc = 0;
			
		if (Collections.binarySearch(list, word) < 0)
		{
			loc = (Collections.binarySearch(list, word) + 1) * -1;
			list.add(loc, word);
		}
	}

	public void remove(String word)
	{
		list.remove(word);
	}

	public String toString()
	{
		String output = "";
		
		for (String word: list)
		{
			output += word + " ";
		}
		return output;
	}
}