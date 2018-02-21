package unit7;

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		number = num;

	}

	public void setNum(int num)
	{
		number = num;

	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int max = 0;
		if (a > b && a > c)
		{
			for (int counter = 1; counter <= a; counter++)
			{
				if (a % counter == 0 && b % counter == 0 && c % counter == 0)
				{
					max = counter;
				}
			}
		}
		if (b > a && b > c)
		{
			for (int counter = 1; counter <= b; counter++)
			{
				if (a % counter == 0 && b % counter == 0 && c % counter == 0)
				{
					max = counter;
				}
			}
		}
		if (c > b && c > a)
		{
			for (int counter = 1; counter <= c; counter++)
			{
				if (a % counter == 0 && b % counter == 0 && c % counter == 0)
				{
					max = counter;
				}
			}
		}


		return max;
	}

	public String toString()
	{
		String output="";
		for (int a = 1; a <= number; a++)
		{
			for (int b = 1; b <= number; b++)
			{
				for (int c = 1; c <= number; c++)
				{
					if (a < b && b < c)
					{
						if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && a % 2 != 0 && b % 2 == 0 && c % 2 != 0 && greatestCommonFactor(a, b, c) == 1)
						{
							output += a + " " + b + " " + c + " \n";
						
						}
						else if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && a % 2 == 0 && b % 2 != 0 && c % 2 != 0 && greatestCommonFactor(a, b, c) == 1)
						{
							output += a + " " + b + " " + c + " \n";
						}
					}
				}
			}
		}
		return output+"\n";
	}
}
