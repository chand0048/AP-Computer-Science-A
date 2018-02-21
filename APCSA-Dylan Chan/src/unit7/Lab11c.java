package unit7;

import static java.lang.System.*;

public class Lab11c
{
   public static void main( String args[] )
   {
	   TriangleThree run = new TriangleThree(3, "A");
	   System.out.println(run.getLetter());
	   
	   run.setTriangle(7, "X");
	   System.out.println(run.getLetter());

	   run.setTriangle(1, "R");
	   System.out.println(run.getLetter());

	   run.setTriangle(5, "T");
	   System.out.println(run.getLetter());
	   
	   run.setTriangle(4, "W");
	   System.out.println(run.getLetter());
	}
}