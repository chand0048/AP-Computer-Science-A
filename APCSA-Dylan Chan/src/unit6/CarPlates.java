package unit6;

import java.util.Random;

public class CarPlates {
	Random randint = new Random();
	public String randomPlate()
	{
		String plate = "";
		for (int counter = 0; counter <= 2; counter++)
		{
			plate += (char) (randint.nextInt(26) + 65);
		}
		for (int counter = 0; counter <= 3; counter++)
		{
			plate += randint.nextInt(10);
		}
		return plate;
	}
	
	public static void main(String[] args)
	{
		CarPlates run = new CarPlates();
		System.out.printf("Random Vehicle Plate: %s", run.randomPlate());
	}
}

