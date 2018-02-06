package unit2;

public class Lab02g
{
	private double fahrenheit;

	public void setFahrenheit(double fahren)
	{
		fahrenheit = fahren;
		
	}

	public double getCelsius()
	{
		double celsius;
		celsius = (fahrenheit - 32) * (5/9.0);
		return celsius;
	}

	public void print()
	{
		System.out.printf("%.2f degress Fahrenheit == %.2f degrees Celsius\n\n", fahrenheit, getCelsius());
	}
	
	public static void main(String[] args)
	{
		Lab02g temp = new Lab02g();
		
		temp.setFahrenheit(98.6);
		temp.print();
		
		temp.setFahrenheit(52.3);
		temp.print();
		
		temp.setFahrenheit(82.45);
		temp.print();
		
		temp.setFahrenheit(75);
		temp.print();
		
		temp.setFahrenheit(212);
		temp.print();
	}
}