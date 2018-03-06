package midtermStudy;

class Table
{
   private int upperBound;
   private int multiplier;

   public Table(int bound, int mult)
   {
	   setNums(bound, mult);
   }	              
 
   public void setNums(int bound, int mult)
   {
	   upperBound = bound;
	   multiplier = mult;
   }	              
   
   public void print()
   {  
	   for (int counter = 1; counter <= upperBound; counter++)
	   {
		   System.out.printf("%s - %s\n", counter, counter * multiplier);
	   }
   }  
}


