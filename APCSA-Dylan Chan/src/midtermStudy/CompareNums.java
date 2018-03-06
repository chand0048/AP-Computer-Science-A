package midtermStudy;

public class CompareNums
{
   private int one,two;

   public CompareNums(int n1, int n2)
   {
      setNums(n1,n2);
   }	              
 
   public void setNums(int n1, int n2)
   {
	   one = n1;
	   two = n2;

   }	              
   
	//returns true of one == two
	//returns false if one != two
   public boolean compare()
   {  
	   if (one == two)
	   {
		   return true;
	   }
	   else
	   {
		   return false;
	   }
   }

	//returns one and two are equal if ==
  	//returns one and two are not equal is !=
   public String toString()
   {  
	   if (compare() == true)
	   {
		   return one + " and " + two + " are equal.\n";
	   }
	   else 
	   {
		   return one + " and " + two + " are not equal.\n";
	   }
   }
}

