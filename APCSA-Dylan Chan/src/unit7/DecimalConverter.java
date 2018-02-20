package unit7;

import java.util.Scanner;

public class DecimalConverter 
{
	private int userInput;
	public DecimalConverter()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter an interger from 0 to 255: ");
		userInput = keyboard.nextInt();
		
		keyboard.close();
	}
	
	public String convertToBinary()
	{
		String binaryValue = "";
		for (int counter = 7; counter >= 1; counter--)
		{
			if (userInput - Math.pow(2, counter) >= 0)
			{
				binaryValue += 1;
				userInput -= Math.pow(2, counter);
			}
			else
			{
				binaryValue += 0;
			}
		}
		if (userInput - 1 == 0)
		{
			binaryValue += 1;
			userInput -= 1;
		}
		else
		{
			binaryValue += 0;
		}
		return binaryValue;
	}
	
	public static void main(String[] args) 
	{
		DecimalConverter convert = new DecimalConverter();
		System.out.printf("Binary Value: %s", convert.convertToBinary());

	}

}
