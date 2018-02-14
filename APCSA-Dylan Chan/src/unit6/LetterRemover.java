package unit6;

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		//call set
	}

	//add in second constructor
	public LetterRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		String cleaned="";
		for (int counter = 0; counter < sentence.length(); counter++)
		{
			if (sentence.charAt(counter) != lookFor)
			{
				cleaned += sentence.charAt(counter);
			}
		}
		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor;
	}
}