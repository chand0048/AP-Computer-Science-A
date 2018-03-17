package unit13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class FancyWords
{
	private String[] wordRay;

	public FancyWords(String sentence)
	{
		setWords(sentence);
	}

	public void setWords(String sentence)
	{
		wordRay = sentence.split(" ");
	}

	public String toString()
	{
		String output="";
		int max = Integer.MIN_VALUE;
		
		for (String word: wordRay)
		{
			if (word.length() > max)
			{
				max = word.length();
			}
		}
		
		for (int index = max - 1; index >= 0; index--)
		{
			for (int wordsIndex = wordRay.length - 1; wordsIndex >= 0; wordsIndex--)
			{
				if (index - (max - wordRay[wordsIndex].length()) < 0)
				{
					output += " ";
				}
				else
				{
					output += wordRay[wordsIndex].charAt(index - (max - wordRay[wordsIndex].length()));
				}
			}
			output += "\n";
		}

		return output+"\n\n";
	}
}
