package unit8;

public class DigitCounter 
{
	int[] numArray = new int[10];
	
	public DigitCounter()
	{
		for (int counter = 0; counter < 100; counter++)
		{
			int randint = (int) Math.floor(Math.random() * 10);
			numArray[randint]++; 
		}
	}
	
	public String toString()
	{
		String response = "";
		for (int item: numArray)
		{
			response += item + " ";
		}
		return response;
	}
	
	public static void main(String[] args) 
	{
		DigitCounter run = new DigitCounter();
		System.out.println(run);

	}
}
