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
		while (counter <= 13)
		{
			if (1 == counter % 2)
			{
				starsAndStripes.stars();
			}
	
			{
				starsAndStripes.stripes();
			}
			
		}
	}
	
	public static void main(String[] args) {

		
		

	}

}
