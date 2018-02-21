package unit7;

import java.util.Scanner;
import java.util.Random;
import static java.lang.System.*;

public class GuessingGame
{
	private int upperBound;
	
	public GuessingGame()
	{

	}

	public void setUpper(int stop)
	{
		upperBound = stop;
	}
	
	public void playGame()
	{
		Scanner keyboard = new Scanner(System.in);
		Random randint = new Random();
		
		int winNum = randint.nextInt(upperBound) + 1;
		int response;
		int counter = 0;

		do 
		{
			out.print(toString());
			response = keyboard.nextInt();
			
			counter++;
		} while (response != winNum);
		
		out.printf("\nIt took you %s guesses to guess %s\n", counter, winNum);
		out.printf("You guessed wrong %.2f%% of the time.\n\n", 100 - (1.0 / counter * 100));
		
		
	}

	public String toString()
	{
		String output = "Enter a number between 1 and " + upperBound;
		return output;
	}
}