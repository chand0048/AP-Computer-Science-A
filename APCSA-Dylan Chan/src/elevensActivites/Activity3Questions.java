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
		boolean permutation = false;
		for (int item1: array1)
		{
			for (int item2: array2)
			{
				if (item1 == item2)
				{
					permutation = true;
					break;
				}
				else
				{
					permutation = false;
				}
			}
			if (permutation == false)
			{
				break;
			}
		}
		return permutation;
	}
	public static void main(String[] args)
	{
		for (int counter = 0; counter < 10; counter++)
		{
			System.out.println(coinFlip());
		}
		
		int[] array1 = {4, 9, 5, 3};
		int[] array2 = {1, 2, 3, 4};
		System.out.println("\n" + arePermutations(array1, array2));
	}
}
