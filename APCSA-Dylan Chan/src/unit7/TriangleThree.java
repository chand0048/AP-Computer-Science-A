package unit7;

import static java.lang.System.*;

public class TriangleThree
{
   private int size;
   private String letter;

	public TriangleThree()
	{
	}

	public TriangleThree(int count, String let)
	{
		size = count;
		letter = let;
	}

	public void setTriangle( int sz, String let )
	{
		size = sz;
		letter = let;
	}

	public String getLetter()
	{
		String triangle = "";
		for (int counter = 1; counter <= size; counter++ )
		{
			for (int spaces = 1; spaces <= size - counter; spaces++)
			{
				triangle += " ";
			}
			for (int characters = 1; characters <= counter;  characters++)
			{
				triangle += letter;
			}
			triangle = toString(triangle);
		}
		return triangle;
	}

	public String toString(String line)
	{
		String output=line;
		return output+"\n";
	}
}