package unit7;

import java.util.Scanner;
import java.util.Random;
import static java.lang.System.*;

public class GuessingGame
{
	private int upperBound;
	private int randNum;
	

	public GuessingGame(int stop, int num)
	{
		upperBound = stop;
		
		Random randint = new Random();
		randNum = num;

	}

	public boolean playGame()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print(toString());
		int response = keyboard.nextInt();
		
		if (response == randNum)
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
		String output="Enter a number between 1 and " + upperBound;
		return output;
	}
}