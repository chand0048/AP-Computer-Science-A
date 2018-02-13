package unit6;

import static java.lang.System.*;
import java.lang.Math;

public class Lab08i
{
	public static void main ( String[] args )
	{
		Prime input = new Prime(24);
		System.out.println(input.toString());
		
		input.setPrime(7);
		System.out.println(input.toString());
		
		input.setPrime(100);
		System.out.println(input.toString());
		
		input.setPrime(113);
		System.out.println(input.toString());
		
		input.setPrime(65535);
		System.out.println(input.toString());
		
		input.setPrime(2);
		System.out.println(input.toString());
		
		input.setPrime(7334);
		System.out.println(input.toString());
		
		input.setPrime(7919);
		System.out.println(input.toString());
		
		input.setPrime(1115125003);
		System.out.println(input.toString());
	}	
}