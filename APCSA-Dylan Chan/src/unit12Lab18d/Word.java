package unit12Lab18d;

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		word = s;
	}

	public int getLength()
	{
		return word.length();
	}
	
	public int compareTo( Word rhs )
	{
		if (getLength() > rhs.getLength())
		{
			return 1;
		}
		else if (getLength() < rhs.getLength())
		{
			return -1;
		}
		else
		{
			for (int index = 0; index < getLength(); index ++)
			{
				if (toString().charAt(index) < rhs.toString().charAt(index))
				{
					return -1;
				}
				else if (toString().charAt(index) > rhs.toString().charAt(index))
				{
					return 1;
				}
				else 
				{
					return 0;
				}
			}
			return 0;
		}
	}

	public String toString()
	{
		return word;
	}
}
