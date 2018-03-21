package unit14Lab24b;

import java.util.Scanner;
import static java.lang.System.*;

public class FancyWord
{
	private char[][] mat;

	public FancyWord()
	{
		mat = new char[0][0];
	}

   public FancyWord(String s)
	{
	   mat = new char[s.length()][s.length()];
	   
	   for (int y = 0; y < s.length(); y++)
	   {
		   int psn = 0;
		   for (int x = 0; x < s.length(); x++)
		   {
			   if (y == 0 || y == mat.length -1)
			   {
				   mat[y][x] = s.charAt(psn);
				   psn++;
			   }
			   else
			   {
				   if (x == y)
				   {
					   mat[y][x] = s.charAt(psn);
					   psn++;
				   }
				   else if (mat.length - 1 - x == y)
				   {
					   mat[y][x] = s.charAt(psn);
					   psn++;
				   }
				   else
				   {
					   mat[y][x] = ' ';
					   psn++;
				   }
			   }
		   }   
	   }
	}

	public String toString()
	{
		String output="";
		
		for (int row = 0; row < mat.length; row++)
		{
			for (int column = 0; column < mat.length; column++)
			{
				output += mat[row][column] + " ";
			}
			output += "\n";
		}

		return output+"\n\n";
	}
}
