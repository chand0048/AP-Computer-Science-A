package unit6;

import java.util.Scanner;

public class SocialSecurity
{
	private String inputNum;
	public SocialSecurity ()
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter your social security number: ");
		inputNum = keyboard.nextLine().trim();
		
		keyboard.close();
	}
	public boolean checkValid()
	{
		boolean valid = false;
		if (inputNum.length() != 11)
		{
			return false;
		}
		for (int counter = 0; counter <= 2; counter++)
		{
			if (inputNum.charAt(counter) >= 48 && inputNum.charAt(counter) <= 57)
			{
				valid = true;
			}
			else
			{
				valid = false;
			}
		}
		for (int counter = 4; counter <= 5; counter++)
		{
			if (inputNum.charAt(counter) >= 48 && inputNum.charAt(counter) <= 57)
			{
				valid = true;
			}
			else
			{
				valid = false;
			}
		}
		for (int counter = 7; counter <= 10; counter++)
		{
			if (inputNum.charAt(counter) >= 48 && inputNum.charAt(counter) <= 57)
			{
				valid = true;
			}
			else
			{
				valid = false;
			}
		}
		if  (inputNum.substring(3, 4).compareTo("-") == 0 && inputNum.substring(6, 7).compareTo("-")== 0)
		{
			valid = true;
		}
		else
		{
			valid = false;
		}
		return valid;
	}
	public static void main(String[] args)
	{
		SocialSecurity user = new SocialSecurity();
		
		String yesNo;
		if (user.checkValid() == true)
		{
			yesNo = "ACCEPTED";
		}
		else
		{
			yesNo = "DECLINED";
		}

		System.out.printf("\nValidation: %s\n", yesNo);
	}
}

