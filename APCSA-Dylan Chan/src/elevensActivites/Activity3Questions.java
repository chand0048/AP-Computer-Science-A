package elevensActivites;

import java.util.Random;

public class Activity3Questions 
{
	public static String coinFlip()
	{
		Random randint = new Random();
		
		int toss = randint.nextInt(3);
		
		if (toss == 0)
		{
			return "tails";
		}
		else
		{
			return "heads";
		}
	}
	
	public static boolean arePermutations(int[] array1, int[] array2)
	{
		boolean notPermutation = false;
		for (int item1: array1)
		{
			for (int item2: array2)
			{
				if (item1 == item2)
				{
					notPermutation = false;
				}
				else
				{
					notPermutation = true;
				}
			}
		}
		return notPermutation;
	}
	public static void main(String[] args)
	{
		for (int counter = 0; counter < 10; counter++)
		{
			System.out.println(coinFlip());
		}
	}
}
