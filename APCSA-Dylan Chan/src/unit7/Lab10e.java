package unit7;

import java.util.Scanner;
import java.util.Random;
import static java.lang.System.*;

public class Lab10e
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		char response;
		
		System.out.print("Guessing Game - How may numbers? ");
		int max = keyboard.nextInt();
		Random randint = new Random();
		GuessingGame guess = new GuessingGame(max, randint.nextInt(max - 1) + 1);
		
		while (guess.playGame() == false)
		{
			
		}




	}
}