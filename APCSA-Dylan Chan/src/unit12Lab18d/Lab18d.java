package unit12Lab18d;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class Lab18d
{
	public static void main( String args[] ) throws IOException
	{
		try
		{
			Scanner file = new Scanner(new File(System.getProperty("user.dir") + "\\src\\unit12Lab18d\\lab18d.dat"));

			int size = file.nextInt();
			file.nextLine();
			
			Word[] wordList = new Word[size];
			
			for (int index = 0; index < wordList.length; index++)
			{
				Word temp = new Word(file.nextLine());
				wordList[index] = temp;
			}
			
			for (int index = 0; index < wordList.length; index++)
			{
				int location = index;
				
				for (int psn = index; psn < wordList.length; psn++)
				{
					if (wordList[psn].compareTo(wordList[location]) == -1)
					{
						location = psn;
					}
				}
				
				Word temp = wordList[index];
				wordList[index] = wordList[location];
				wordList[location] = temp;
			}
			
			for (Word item: wordList)
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