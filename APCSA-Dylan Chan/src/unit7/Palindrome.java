package unit7;

public class Palindrome 
{
	private int number, reversed;
	
	public Palindrome(int num)
	{
		number = num;
	}
	
	public void setNum(int num)
	{
		number = num;
	}
	
	public int reverseInt()
	{
		int temp = number;
		reversed = 0;
		while (temp > 0 )
		{
			reversed = reversed * 10 + temp % 10;
			temp  /= 10;
		}
		return reversed;

	}
	
	public boolean isPalindrome()
	{
		boolean status = false;
		if (reversed == number)
		{
			status = true;
		}
		return status;
	}
	
	public static void main(String[] args)
	{
		Palindrome run = new Palindrome(343);
		System.out.println(343);
		System.out.println(run.reverseInt());
		System.out.println(run.isPalindrome());
		
		System.out.println();
		
		run.setNum(456);
		System.out.println(456);
		System.out.println(run.reverseInt());
		System.out.println(run.isPalindrome());
	}
}
