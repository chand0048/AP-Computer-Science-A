package unit3;

public class Lab03c 
{
	
	public static void main(String[] args)
	{
		Quadratic equation1 = new Quadratic(5, -8, 3);
		equation1.calcRoots();
		equation1.print();
		
		Quadratic equation2 = new Quadratic(3, 2, -7);
		equation2.calcRoots();
		equation2.print();
		
		Quadratic equation3 = new Quadratic(9, 6, 1);
		equation3.calcRoots();
		equation3.print();
		
		Quadratic inputEquation = new Quadratic();
		inputEquation.calcRoots();
		inputEquation.print();

	}

}
