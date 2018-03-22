package unit14;

public class Matrices 
{
	private int[][] matrix;
	
	public Matrices()
	{
		matrix = new int[6][6];
		
		for (int y = 0; y < matrix.length; y++)
		{
			for (int x = 0; x < matrix.length; x++)
			{
				matrix[y][x] = (int) Math.floor(Math.random() * 2);
			}
		}
	}
	
	public boolean checkRow(int y)
	{
		int sum = 0;
		for (int x = 0; x < matrix.length; x++)
		{
			sum += matrix[y][x];
		}
		
		if (sum % 2 == 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean checkColumn(int x)
	{
		int sum = 0;
		for (int y = 0; y < matrix.length; y++)
		{
			sum += matrix[y][x];
		}
		
		if (sum % 2 == 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public String toString()
	{
		String output = "";
		for (int y = 0; y < matrix.length; y++)
		{
			for (int x = 0; x < matrix.length; x++)
			{
				output += matrix[y][x] + " ";
			}
			output += "\n";
		}
		
		output +="\n";
		
		for (int row = 0; row < matrix.length; row++)
		{
			if (checkRow(row))
			{
				output += "Row " + row + " has an even number of 1s\n";
			}
		}
		output +="\n";
		
		for (int column = 0; column < matrix.length; column++)
		{
			if (checkColumn(column))
			{
				output += "Column " + column + " has an even number of 1s\n";
			}
		}
		
		return output;
	}
	
	public static void main(String[] args)
	{
		Matrices test = new Matrices();
		System.out.println(test);
	}

}
