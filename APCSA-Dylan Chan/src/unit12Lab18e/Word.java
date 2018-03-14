package unit12Lab18e;

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s)
	{
		word = s;
	}

	private int numVowels()
	{
		String vowels = "AEIOUaeiou";
		int vowelCount=0;
		
		for (char item: word.toCharArray())
		{
			for (char vowel: vowels.toCharArray())
			{
				if (item == vowel)
				{
					vowelCount++;
					break;
				}
			}
		}

		return vowelCount;
	}
	
	public int getLength()
	{
		return word.length();
	}

	public int compareTo(Word rhs)
	{
		if (this.numVowels() > rhs.numVowels())
		{
			return 1;
		}
		else if (this.numVowels() < rhs.numVowels())
		{
			return -1;
		}
		else
		{
			for (int index = 0; index < this.getLength(); index++)
			{
				if (this.toString().charAt(index) > rhs.toString().charAt(index))
				{
					return 1;
				}
				else if (this.toString().charAt(index) < rhs.toString().charAt(index))
				{
					return -1;
				}
			}
			
			return 0;
		}
	}

	public String toString()
	{
		return word;
	}
}
