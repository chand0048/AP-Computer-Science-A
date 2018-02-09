package unit2;

public class Circle
{
	private double radius;
	private double area;

	public Circle(double rad)
	{
		radius = rad;
	}
	
	public void setRadius(double rad)
	{
		radius = rad;
	}

	public void calculateArea( )
	{
		area = Math.PI * Math.pow(radius, 2);
	}

	public void print( )
	{
		System.out.printf("The area is: %.4f\n\n", area);
	}
}