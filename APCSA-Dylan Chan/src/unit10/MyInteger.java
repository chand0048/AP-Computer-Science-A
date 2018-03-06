package unit10;

public class MyInteger 
{
	private int number;
	
	public MyInteger(int num)
	{
		number = num;
	}
	
	public int getNum()
	{
		return number;
	}
	
	public boolean isEven()
	{
		if (number % 2 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isEven(int num)
	{
		if (num % 2 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isOdd()
	{
		if (number % 2 != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isOdd(int num)
	{
		if (num % 2 != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isPrime()
	{
		int factors = 0;
		
		for (int counter = 1; counter <= number; counter++)
		{
			if (number % counter == 0)
			{
				factors++;
			}
		}
		
		if (factors == 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean isPrime(int num)
	{
		int factors = 0;
		
		for (int counter = 1; counter <= num; counter++)
		{
			if (num % counter == 0)
			{
				factors++;
			}
		}
		
		if (factors == 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean equals(int num)
	{
		if (number == num)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean equals(MyInteger num)
	{
		if (number == num.getNum())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static int parseInt(char[] numsArray)
	{
		int equals = 0;
		
		for (char item: numsArray)
		{
			equals += item;
			equals *= 10;
		}
		equals /= 10;
		return equals;
	}
	
	public static int parseInt(String nums)
	{
		int equals = 0;
		
		for (char item: nums.toCharArray())
		{
			equals += item - 48;
			equals *= 10;
		}
		equals /= 10;
		return equals;
	}
	
	public static void main(String [] args)
	{
		MyInteger test = new MyInteger(56);
		
		System.out.printf("Get Num: %s\n", test.getNum());
		System.out.printf("Is Even: %s\n", test.isEven());
		System.out.printf("Is Odd: %s\n", test.isOdd());
		System.out.printf("Is Prime: %s\n", test.isPrime());
		
		System.out.println("\n71");
		System.out.printf("Is Even: %s\n", isEven(71));
		System.out.printf("Is Odd: %s\n", isOdd(71));
		System.out.printf("Is Prime: %s\n", isPrime(71));
		
		System.out.printf("%s equals 56? %s\n", test.getNum(), test.equals(56));
		MyInteger testEquals = new MyInteger(71);
		System.out.printf("%s equals %s? %s\n", test.getNum(),testEquals.getNum(), test.equals(testEquals));
		
		char[] testArray = {2, 3};
		System.out.printf("parseInt([2, 3]) = %s\n", parseInt(testArray));
		
		
		System.out.printf("parseInt(\"34\") = %s", parseInt("34"));
	}
	
}
