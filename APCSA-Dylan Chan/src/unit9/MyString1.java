package unit9;

public class MyString1 {
	private char[] characters;
	
	public MyString1(char[] chars)
	{
		characters = chars;
	}
	public char charAt(int index)
	{
		return characters[index];
	}
	public int length()
	{
		return characters.length;
	}
	public MyString1 substring(int begin, int end)
	{
		char[] temp = new char [end - begin];
		
		for (int index = begin; index < end; index++)
		{
			temp[index-begin] = characters[index];
		}
		
		MyString1 part = new MyString1(characters);
		return part;
	}
	public MyString1 toLowerCase()
	{
		char[] temp = new char[characters.length];
		
		for (int index = 0; index < characters.length; index++)
		{
			if (characters[index] >= 65 && characters[index] <= 90)
			{
				temp[index] = (char) (characters[index] + 32);
			}
		}
		MyString1 lowerCase = new MyString1(temp);
		
		return lowerCase;
	}
	public boolean equals(MyString1 s)
	{
		boolean temp = false;
		for (int index = 0; index < s.length(); index++)
		{
			if (characters[index] == s.charAt(index))
			{
				temp = true;
			}
		}
		
		return temp;
	}
	public static MyString1 valueOf(int i)
	{
		char[] temp;
		int intLength = 0;
		int tempInt1 = i;
		int tempInt2 = i;
		
		while (tempInt1 > 0)
		{
			intLength++;
			tempInt1 /= 10;
		}
		temp = new char[intLength];
		
		for (int index = intLength - 1; index >= 0; index--)
		{
			temp[index] = (char) ((tempInt2 % 10) + 48);
			tempInt2 /= 10;
		}
		
		MyString1 convert = new MyString1(temp);
		return convert;
	}

}
