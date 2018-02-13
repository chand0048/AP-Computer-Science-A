package unit6;

import static java.lang.System.*;

public class Lab08g
{
	public static void main ( String[] args )
	{
		LoopStats input = new LoopStats(1, 5);
		System.out.println(input.toString());
		
		input.setNums(2, 8);
		System.out.println(input.toString());
		
		input.setNums(5, 15);
		System.out.println(input.toString());
		
		
					
	}
}