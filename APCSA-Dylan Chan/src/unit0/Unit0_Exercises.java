package unit0;

public class Unit0_Exercises {
	public static void main(String[] args) 
	{
	//Exercise 1
	System.out.println("Exercise One");
	System.out.println("____________________");
	System.out.println("|a\ta^2\ta^3|");
	System.out.println("|__________________|");
	System.out.println("|1\t1\t1  |");
	System.out.println("|2\t4\t8  |");
	System.out.println("|3\t9\t27 |");
	System.out.println("|4\t16\t64 |");
	System.out.println("|__________________|");
	    
	    
	//Exercise 2
	System.out.println("\n\nExercise Two");
	System.out.printf("9.5 * 4.5 = %s", (9.5 * 4.5));
	System.out.printf("\n-2.5 * 3 = %s", (-2.5 * 3));
	System.out.printf("\n45.5 - 3.5 = %s", (45.5 - 3.5));
	    
	    
	//Exercise Three 
	System.out.println("\n\n\nExercise Three");
	int population = 312032486;
	int counter = 1;
	    
	System.out.printf("\nYear 0-U.S. Population: %s", population);
	while (counter <= 5)
	{
		population += (365 * 24 * 60 * 60)/7.0;
	    population -= (365 * 24 * 60 * 60)/13.0;
	    population += (365 * 24 * 60 * 60)/45.0;
	    System.out.printf("\nYear %s-U.S. Population: %s", counter, population);
	    counter += 1;
	}
	}
}
