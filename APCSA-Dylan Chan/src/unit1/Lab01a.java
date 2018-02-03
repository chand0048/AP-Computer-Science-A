package unit1;

public class Lab01a 
{
	public void stars()
	{
		System.out.println("-------------------------------------------");
	}
	
	public void stripes()
	{
		System.out.println("*******************************************");
	}
	
	public void box()
	{
		int counter = 0;
		Lab01a starsAndStripes = new Lab01a();
		while (counter <= 12)
		{
			if (1 == counter % 2)
			{
				starsAndStripes.stars();
			}
			if (0 == counter % 2)
			{
				starsAndStripes.stripes();
			}
		counter += 1;
		}
	}
	
	public static void main(String[] args) 
	{
		Lab01a starsAndStripes = new Lab01a();
		starsAndStripes.box();
		
		

	}

}
