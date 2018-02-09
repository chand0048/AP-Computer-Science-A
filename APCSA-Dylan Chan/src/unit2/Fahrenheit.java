package unit2;

public class Fahrenheit
{
	private double fahrenheit;

	public Fahrenheit(double fahren)
	{
		fahrenheit = fahren;
	}
	
	public void setFahrenheit(double fahren)
	{
		fahrenheit = fahren;
	}

	public double getCelsius()
	{
		double celsius = 0.0;
		celsius = (fahrenheit - 32) * (5/9.0);
		return celsius;
	}

	public void print()
	{
		System.out.printf("%.2f degress Fahrenheit == %.2f degrees Celsius\n\n", fahrenheit, getCelsius());
	}
}
