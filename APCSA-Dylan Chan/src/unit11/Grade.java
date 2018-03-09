package unit11;

public class Grade
{
	private double value;
	
	//add in two constructors
	public Grade()
	{
		setGrade(0);
	}
	
	public Grade(double score)
	{
		setGrade(score);
	}
		
	//add in set and get methods
		//String getLetterGrade()
		//double getNumericGrade()
	
	public void setGrade(double score)
	{
		value = score;
	}
	
	public String getLetterGrade()
	{
		if (value >= 90)
		{
			return "A";
		}
		else if (value >= 80)
		{
			return "B";
		}
		else if (value >= 70)
		{
			return "C";
		}
		else if (value >= 60)
		{
			return "D";
		}
		else 
		{
			return "F";
		}
	}
	
	public double getNumericGrade()
	{
		return value;
	}
	
	//toString method
	public String toString()
	{
		return getNumericGrade() + " - " + getLetterGrade();
	}
}
