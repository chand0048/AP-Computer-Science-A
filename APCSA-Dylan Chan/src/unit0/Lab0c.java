package unit0;

import java.util.Scanner;

public class Lab0c {
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
	    int intOne, intTwo;
	    double doubleOne, doubleTwo;
	    float floatOne, floatTwo;
	    short shortOne, shortTwo;
	    
	    System.out.print("Enter an integer: ");
	    intOne = keyboard.nextInt();
	    System.out.print("Enter an integer: ");
	    intTwo = keyboard.nextInt();
	    
	    System.out.print("Enter a double: ");
	    doubleOne = keyboard.nextDouble();
	    System.out.print("Enter a double: ");
	    doubleTwo = keyboard.nextDouble();
	    
	    System.out.print("Enter a float: ");
	    floatOne = keyboard.nextFloat();
	    System.out.print("Enter a float: ");
	    floatTwo = keyboard.nextFloat();
	    
	    System.out.print("Enter a short: ");
	    shortOne = keyboard.nextShort();
	    System.out.print("Enter a short: ");
	    shortTwo = keyboard.nextShort();
	    
	    keyboard.close();
	    
	    System.out.println("\n");
	    
	    System.out.println("Integer One = " + intOne);
	    System.out.println("Integer Two = " + intTwo);
	    System.out.println("\nDouble One = " + doubleOne);
	    System.out.println("Double Two = " + doubleTwo);
	    System.out.println("\nFloat One = " + floatOne);
	    System.out.println("Float Two = " + floatTwo);
	    System.out.println("\nShort One = " + shortOne);
	    System.out.println("Short Two = " + shortTwo);		
	}
}
