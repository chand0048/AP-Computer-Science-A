package unit4;

import static java.lang.System.*;

public class StringChecker
{
	private String word;

	public StringChecker()
	{
		

	}

	public StringChecker(String s)
	{
		word = s;

	}

   public void setString(String s)
   {
   		word=s;
   }

	public boolean findLetter(char c)
	{
		if (word.indexOf(c) % 1 == 0)
		{
			return true;
		}


		return false;
	}

	public boolean findSubString(String s)
	{
		int previousIndex;
		boolean there = false;
		
		if (word.indexOf(s.substring(0, 1)) % 1 == 0 )
		{
			previousIndex = word.indexOf(s.substring(0, 1));
			
			for (int counter = 1; s.length() <= counter-1 ; counter++)
			{
				if (word.indexOf(s.substring(counter, counter + 1)) == previousIndex + 1)
				{
					there = true;
				}
				else
				{
					there = false;
				}
			}
			
			return false;
		}
		

		return false;
	}

 	public String toString()
 	{
 		return "\n\n";
	}
}
