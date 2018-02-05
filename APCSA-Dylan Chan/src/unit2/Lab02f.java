package unit2;

public class Lab02f 
{
	public double calcSlope(double x1, double y1, double x2, double y2)
	{
		double slope = (y2-y1) / (x2-x1);
		return slope;
	}
	public static void main(String[] args)
	{
		Lab02f graph = new Lab02f();
		
		System.out.printf("The slope is %.2f\n", graph.calcSlope(1, 9, 14, 2));
		System.out.printf("The slope is %.2f\n" , graph.calcSlope(1, 7, 18, 3));
		System.out.printf("The slope is %.2f\n", graph.calcSlope(6, 4, 2, 2));
		System.out.printf("The slope is %.2f\n" , graph.calcSlope(4, 4, 5, 3));
		System.out.printf("The slope is %.2f\n" , graph.calcSlope(1, 1, 2, 9));
		
	}
}
