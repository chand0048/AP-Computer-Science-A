package unit11LabAssesment;

public class Product 
{
	private String productName;
	private Price productPrice; 
	
	public Product()
	{
		productPrice = new Price(0);
		setName("");
	}
	
	public Product(String name, double amount)
	{
		productPrice = new Price(amount);
		setName(name);
	}
	
	public void setName(String name)
	{
		productName = name;
	}
	
	public void setCost(double amount)
	{
		productPrice.setCost(amount);
	}
	
	public String getName()
	{
		return productName;
	}
	
	public double getCost()
	{
		return productPrice.getCost();
	}
	
	public String toString()
	{
		return productName + " - " + productPrice;
	}
}
