package unit14;

import static java.lang.System.*;

public class Lab21g
{
	public static void main(String args[])
	{
		//instantiate an AtCounter

		AtCounter test = new AtCounter();
		
		//test the code
		
		test.countAts(0, 0);
		System.out.println("0 0 has " + test);
		
		test.countAts(2, 5);
		System.out.println("2 5 has " + test);
		
		test.countAts(5, 0);
		System.out.println("5 0 has " + test);
		
		test.countAts(9, 9);
		System.out.println("9 9 has " + test);
		
		test.countAts(3, 9);
		System.out.println("3 9 has " + test);
		
		
	}
}
