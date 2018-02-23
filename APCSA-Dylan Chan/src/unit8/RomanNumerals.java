package unit8;

public class RomanNumerals
{
	private int number;
	private String roman;

	private final static int[] sortedNUMBERS= {900,400,90,40,9,4,
			1000,500,100,50,10,5,1};

	private final static String[] sortedLETTERS = {"CM","CD","XC","XL","IX","IV",
			  "M","D","C","L","X","V","I"};

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
			50,40,10,9,5,4,1};
	
	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
			  "L","XL","X","IX","V","IV","I"};
	
	public RomanNumerals(String str)
	{
		roman = str;
		number = 0;
		String temp = str;
		for (int index = 0; index < sortedLETTERS.length; index++)
		{
			int psn = 0;
			while (psn != temp.length())
			{
				if (temp.indexOf(sortedLETTERS[index], psn) >= 0)
				{
					psn = temp.indexOf(sortedLETTERS[index]);
					if (sortedLETTERS[index].length() == 2)
					{
						temp = temp.substring(0, psn) + temp.substring(psn + 2);
					}
					else 
					{
						temp = temp.substring(0, psn) + temp.substring(psn + 1);
					}
					number += sortedNUMBERS[index];
				}
				else
				{
					psn++;
				}
			}
		}
	}

	public RomanNumerals(Integer num)
	{
		number = num;
		roman = "";
		int temp = num;
		for (int index = 0; index < NUMBERS.length; index++)
		{
			while (temp >= NUMBERS[index])
			{
				roman += LETTERS[index];
				temp -= NUMBERS[index];
			}
		}
	}

	public void setRoman(String str)
	{
		roman = str;
		number = 0;
		String temp = str;
		for (int index = 0; index < sortedLETTERS.length; index++)
		{
			int psn = 0;
			while (psn != temp.length())
			{
				if (temp.indexOf(sortedLETTERS[index], psn) >= 0)
				{
					psn = temp.indexOf(sortedLETTERS[index]);
					if (sortedLETTERS[index].length() == 2)
					{
						temp = temp.substring(0, psn) + temp.substring(psn + 2);
					}
					else 
					{
						temp = temp.substring(0, psn) + temp.substring(psn + 1);
					}
					number += sortedNUMBERS[index];
				}
				else
				{
					psn++;
				}
			}
		}
	}

	public void setNumber(Integer num)
	{
		number = num;
		roman = "";
		int temp = num;
		for (int index = 0; index < NUMBERS.length; index++)
		{
			while (temp >= NUMBERS[index])
			{
				roman += LETTERS[index];
				temp -= NUMBERS[index];
			}
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