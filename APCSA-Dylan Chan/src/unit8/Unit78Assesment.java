package unit8;

import java.util.Scanner;
import java.util.Random;

public class Unit78Assesment {
	private int misses;
	private String correctWord;
	
	private final String[] wordsArray = {"valley", "stream", "airplane", "assesment", "engineering"};
	
	public Unit78Assesment()
	{
	
	}
	
	public void setNewWord()
	{
		Random randint = new Random();
		correctWord = wordsArray[randint.nextInt(wordsArray.length)];
	}
	
	public void playHangman()
	{
		Scanner keyboard = new Scanner(System.in);
		
		String tempWord = "";
		String userGuess = "";
		misses = 0;
		//Sets the GUI word
		for (int counter = 0; counter < correctWord.length(); counter++)
		{
			tempWord += "*";
		}
		
		while (tempWord.compareTo(correctWord) != 0)
		{
			System.out.printf("(GUESS) Enter a letter in the word %s > ", tempWord);
			userGuess = keyboard.nextLine().toLowerCase();
			
			if (correctWord.indexOf(userGuess) >= 0 && tempWord.indexOf(userGuess) < 0)
			{
				int psn = 0;
				while (psn != tempWord.length())
				{
					tempWord = tempWord.substring(0, correctWord.indexOf(userGuess, psn)) + userGuess + tempWord.substring(correctWord.indexOf(userGuess, psn) + 1);
					psn = correctWord.indexOf(userGuess, psn) + 1;
					if (correctWord.indexOf(userGuess, psn) < 0)
					{
						psn = tempWord.length();
					}
				}
			}
			else if (correctWord.indexOf(userGuess) >= 0 && tempWord.indexOf(userGuess) >= 0)
			{
				System.out.printf("       %s is already in the word\n", userGuess);
			}
			else
			{
				System.out.printf("       %s is not a letter in the word\n", userGuess);
				misses++;
			}
		}
		
		System.out.println(toString());
	}
	
	public String toString()
	{
		String response = "The word is " + correctWord + ". You missed " + misses + " time(s).\n\n";
		return response;
	}
	
	public static void main(String[] args)
	{
		Unit78Assesment run = new Unit78Assesment();
		
		Scanner keyboard = new Scanner(System.in);
		
		do
		{
			run.setNewWord();
			run.playHangman();
			System.out.print("Would you like to play again(Enter y/n)? ");
		} while (keyboard.nextLine().toLowerCase().compareTo("y") == 0);
		
		System.out.println("Thank you for playing!");
		
		keyboard.close();
		
	}
}
