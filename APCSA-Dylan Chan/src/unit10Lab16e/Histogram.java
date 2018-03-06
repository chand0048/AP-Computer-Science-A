package unit10Lab16e;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count;
	private ArrayList<Character> letters;
	private String fileName;

	public Histogram()
	{




	}

	public Histogram(char[] values, String fName)
	{
		count = new ArrayList();
		letters = new ArrayList();
		
		fileName = fName;
		
		for (char item: values)
		{
			letters.add(item);
		}
		
		for (char item: values)
		{
			count.add(0);
		}

		out.println("search letters = "+letters);
	}

	public void loadAndAnalyzeFile() throws IOException
	{
		try
		{
			Scanner file = new Scanner(new File(System.getProperty("user.dir") + "\\src\\unit10Lab16e\\" + fileName));
			
			while (file.hasNextLine())
			{
				String line = file.nextLine();
				
				for (int index = 0; index < letters.size(); index++)
				{
					int psn = 0;
					
					while (line.indexOf(letters.get(index), psn) >= 0)
					{
						count.set(index, count.get(index) + 1);
						psn = line.indexOf(letters.get(index), psn) + 1;
					}
				}
			}
			
		}
		catch (Exception e)
		{
			out.println(e);
		}
	}

	public char mostFrequent()
	{
		int max = 0;
		int location = 0;
		
		for (int index = 0; index < count.size(); index++)
		{
			if (count.get(index) > max)
			{
				max = count.get(index);
				location = index;
			}
		}
		return letters.get(location);
	}

	public char leastFrequent()
	{
		int min = count.get(0);
		int location = 0;
		
		for (int index = 0; index < count.size(); index++)
		{
			if (count.get(index) < min)
			{
				min = count.get(index);
				location = index;
			}
		}
		return letters.get(location);
	}

	public String toString()
	{
	   return fileName
	   + "\n" + letters
	   + "\n" + count + "\n\n\n";
	}
}
