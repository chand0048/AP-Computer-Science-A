package unit11LabAssesment;

import java.text.DecimalFormat;

public class Price 
{
	private double cost;
	
	public Price()
	{
		setCost(0);
	}
	
	public Price(double amount)
	{
		setCost(amount);
	}
	
	public void setCost(double amount)
	{	
		cost = amount;
	}
	
	public double getCost()
	{
		return cost;
	}
	
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("#.00");
		
		return "$ " + df.format(cost);
	}
}
