package unit6;

import static java.lang.System.*;
import java.lang.Math;

public class Prime
{
	private int number;

	public Prime()
	{
		

	}

	public Prime(int num)
	{
		number = num;
	}

	public void setPrime(int num)
	{
		number = num;
	}

	public boolean isPrime()
	{
		int numMultiples = 0;
		for (int counter = 1; counter <= number; counter++)
		{
			if (number % counter == 0)
			{
				numMultiples++;
			}
		}
		if (numMultiples == 2)
		{
			return true;
		}
		else
		{
			return false;
		}		
	}

	public String toString()
	{
		String yesNo;
		if (isPrime() == true)
		{
			yesNo = " is ";
		}
		else
		{
			yesNo = " isn\'t ";
		}
		String output= number + yesNo + "a prime number.\n";

		return output;
	}
}