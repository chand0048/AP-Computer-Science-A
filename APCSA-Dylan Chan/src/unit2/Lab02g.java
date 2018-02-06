package unit2;

public class Lab02g
{
	private double fahrenheit;

	public void setFahrenheit(double fahren)
	{
		fahrenheit = fahren;
		System.out.println(fahrenheit);
		
	}

	public double getCelsius()
	{
		double celsius;
		celsius = (fahrenheit - 32) * 5/9;
		return celsius;
	}

	public void print()
	{
		System.out.println(getCelsius());
	}
	
	public static void main(String[] args)
	{
		Lab02g temp = new Lab02g();
		
		temp.setFahrenheit(98.5);
		temp.getCelsius();
		temp.print();
	}
}