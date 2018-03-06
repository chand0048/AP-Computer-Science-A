package midtermStudy;

public class TotalItUp
{
   private int numOne, numTwo, answer;
 
   public void setNums(int n1, int n2)
   {
	   numOne = n1;
	   numTwo = n2;
   }	              
   
	//method add totals up numOne and numTwo
   public void add()
   {  
	   answer = numOne + numTwo;
   }

	//method print displays the sum of numOne and numTwo
   public void print()
   {  
	   System.out.printf("%s + %s = %s\n\n", numOne, numTwo, answer);
   }
}
