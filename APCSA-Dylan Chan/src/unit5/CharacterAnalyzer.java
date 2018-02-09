package unit5;

import static java.lang.System.*;
import java.util.Scanner;

public class CharacterAnalyzer
{
	private char theChar;

	public CharacterAnalyzer()
	{


	}

	public CharacterAnalyzer(char c)
	{
		theChar = c;

	}

	public void setChar(char c)
	{
		theChar = c;

	}

	public char getChar()
	{
		return theChar;
	}

	public boolean isUpper( )
	{
		if (theChar >= 65 && theChar <= 90)
		{
			return true;
		}

		return false;
	}

	public boolean isLower( )
	{
		if (theChar >= 97 && theChar <= 122)
		{
			return true;
		}

		return false;
	}
	
	public boolean isNumber( )
	{
		if (theChar >= 48 && theChar <= 57)
		{
			return true;
		}

		return false;
	}	

	public int getASCII( )
	{
		return (int) theChar;
	}

	public String toString()
	{
		if (isUpper() == true)
		{
			return ""+getChar() + " is an uppercase character. ASCII == " + getASCII() + "\n";
		}
		else if (isLower() == true)
		{
			return ""+getChar() + " is a lowercase character. ASCII == " + getASCII() + "\n";
		}
		else if (isNumber() == true)
		{
			return ""+getChar() + " is a number character. ASCII == " + getASCII() + "\n";
		}
		else
		{
			return ""+getChar() + " is another type of symbol. ASCII == " + getASCII() + "\n";
		}
  
	}
}