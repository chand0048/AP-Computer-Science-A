package unit11;

import static java.lang.System.*;

public class WordPrinter
{
	//instance variables and constructors could be present, but are not necessary
		
	public static void printWord(String word, int times)
	{
		for (int counter = 0; counter < times; counter++)
		{
			System.out.println(word);
		}

	}
}
