package unit4;

import java.util.Scanner;

public class Lab04b 
{
	String word;
	public Lab04b()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Word: ");
		word = keyboard.nextLine();
		
		keyboard.close();
		
	}
	public void firstChar()
	{
		char firstLetter = word.charAt(0);
		
		System.out.println("First letter: " + firstLetter);
	}
	public void lastChar()
	{
		char lastLetter = word.charAt(word.length() - 1);
		
		System.out.println("Last letter: " + lastLetter);
	}
	public static void main(String[] args)
	{
		Lab04b run = new Lab04b();
		run.firstChar();
		run.lastChar();
	}
}
