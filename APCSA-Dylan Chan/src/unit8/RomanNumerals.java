package unit8;

import static java.lang.System.*;

public class RomanNumerals
{
	private int number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumerals(String str)
	{
		roman = str;
		String temp = str;
		while (temp.length() > 0)
		{
			for (int index = 0; index < LETTERS.length; index++)
			{
				if (temp.indexOf(LETTERS[index]) > 0)
				{
					if (LETTERS[index].length() == 2 && temp.length() == 1)
					{
						temp = "";
					}
					else if(LETTERS[index].length() == 1 && temp.length() == 1)
					{
						temp = "";
					}
					number += NUMBERS[index];
					if (LETTERS[index].length() == 2)
					{
						temp = temp.substring(0, temp.indexOf(LETTERS[index])) + temp.substring(temp.indexOf(LETTERS[index] + 2));
					}
					else if(LETTERS[index].length() == 1)
					{
						temp = temp.substring(0, temp.indexOf(LETTERS[index])) + temp.substring(temp.indexOf(LETTERS[index] + 1));
					}
					number += NUMBERS[index];
				}
			}
		}
	}


	

	public RomanNumerals(Integer num)
	{
		number = num;


	}

	public void setNumber(Integer num)
	{
		number = num;




	}

	public void setRoman(String str)
	{
		roman = str;
		for (int index = 0; index < roman.length(); index++)
		{
			
		}


	}

	public Integer getNumber()
	{
		return number;
	}

	public String toString()
	{
		return roman + "\n";
	}
}