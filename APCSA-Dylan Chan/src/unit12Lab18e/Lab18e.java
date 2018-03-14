package unit12Lab18e;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class Lab18e
{
	public static void main( String args[] ) throws IOException
	{
		try
		{
			Scanner file = new Scanner(new File(System.getProperty("user.dir") + "\\src\\unit12Lab18e\\lab18e.dat"));
			
			int size = file.nextInt();
			file.nextLine();
			
			Word[] wordArray = new Word[size];
			
			for (int index = 0; index < wordArray.length; index++)
			{
				Word temp = new Word(file.nextLine());
				wordArray[index] = temp;
			}
			
			for (int index = 0; index < wordArray.length; index++)
			{
				int location = index;
				
				for (int psn = index; psn < wordArray.length; psn++)
				{
					if (wordArray[psn].compareTo(wordArray[location]) == -1)
					{
						location = psn;
					}
				}
				
				Word temp = wordArray[index];
				wordArray[index] = wordArray[location];
				wordArray[location] = temp;
			}
			
			for (Word item: wordArray)
			{
				out.println(item);
			}
		}
		catch (Exception e)
		{
			out.println(e);
		}
	}
}