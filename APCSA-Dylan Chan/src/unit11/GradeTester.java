package unit11;

public class GradeTester 
{
	public static void main(String [] args)
	{
		Grade test1 = new Grade(72.3);
		
		System.out.println(test1.getNumericGrade());
		System.out.println(test1.getLetterGrade());
		System.out.println(test1);
		
		System.out.println();
		
		test1.setGrade(91.2);
		System.out.println(test1.getNumericGrade());
		System.out.println(test1.getLetterGrade());
		System.out.println(test1);
	}
}
