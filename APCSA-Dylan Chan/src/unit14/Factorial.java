package unit14;

public class Factorial 
{
	private int product;
	
	public Factorial()
	{
		product = 0;
		calcFactorial(10);
	}
	
	public void calcFactorial(int num)
	{
		if (product == 0)
		{
			product += num;
			calcFactorial(num - 1);
		}
		else if(num != 0)
		{
			product *= num;
			calcFactorial(num - 1);
		}
		else
		{
			System.out.println(product);
		}
	}
	
	public static void main(String[] args)
	{
		Factorial test = new Factorial();
	}
}
