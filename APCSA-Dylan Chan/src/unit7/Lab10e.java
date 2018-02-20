package unit7;

import java.util.Scanner;
import java.util.Random;
import static java.lang.System.*;

public class Lab10e
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		
		GuessingGame game = new GuessingGame();
		
		
		do
		{
			System.out.print("\n\nGuessing Game - How may numbers? ");
			
			game.setUpper(keyboard.nextInt());
			keyboard.nextLine();
			game.playGame();
			
			System.out.print("Would you like to play again(y/n)? ");
		} while (keyboard.nextLine().compareTo("y") == 0);
		
		keyboard.close();
		System.out.print("\nThank you for playing");



	}
}