package unit2;

public class Lab02f 
{

	public static void main(String[] args)
	{
		Line line1 = new Line(1, 9, 14, 2);
		line1.calculateSlope();
		line1.print();
		
		Line line2 = new Line(1, 7, 18, 3);
		line2.calculateSlope();
		line2.print();
		
		Line line3 = new Line(6, 4, 2, 2);
		line3.calculateSlope();
		line3.print();
		
		Line line4 = new Line(4, 4, 5, 3);
		line4.calculateSlope();
		line4.print();
		
		Line line5 = new Line(1, 1, 2, 9);
		line5.calculateSlope();
		line5.print();

		
	}
}
