package unit10;

import static java.lang.System.*;

public class Word
{
	private String word;
	private static String vowels = "AEIOUaeiou";   //only one

	public Word()
	{
		
	}

	public Word(String wrd)
	{
		word = wrd;
	}

	public void setWord(String wrd)
	{
		word = wrd;
	}
	
	public int getNumVowels()
	{
		int count=0;
		for (char letterWord: word.toCharArray())
		{
			for (char vowel: vowels.toCharArray())
			{
				if (letterWord == vowel)
				{
					count++;
				}
			}
		}
		return count;
	}
	
	public int getLength()
	{
		return word.length();
	}

	public String toString()
	{
	   return word + "\nnum vowels == " + getNumVowels() + "\nnum chars == " + getLength() + "\n\n";
	}
}