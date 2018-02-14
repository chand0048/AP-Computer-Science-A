package unit6;

import static java.lang.System.*;

public class Lab09f
{
	public static void main( String args[] )
	{
		LetterRemover input = new LetterRemover("I am Sam I am", 'a');
		System.out.printf("%s\n%s\n\n", input.toString(), input.removeLetters());
		
		input.setRemover("ssssssssxssssesssssesss", 's');
		System.out.printf("%s\n%s\n\n", input.toString(), input.removeLetters());
		
		input.setRemover("qwertyqwertyqwerty", 'a');
		System.out.printf("%s\n%s\n\n", input.toString(), input.removeLetters());
		
		input.setRemover("abababababa", 'b');
		System.out.printf("%s\n%s\n\n", input.toString(), input.removeLetters());
		
		input.setRemover("abaababababa", 'x');
		System.out.printf("%s\n%s\n\n", input.toString(), input.removeLetters());
											
	}
}