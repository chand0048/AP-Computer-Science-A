package unit8;

public class Lab14i
{
	public static void main( String args[] )
	{
		RomanNumerals test = new RomanNumerals(10);
		System.out.printf("%s is %s", test.getNumber(), test);
		
		test.setNumber(100);
		System.out.printf("%s is %s", test.getNumber(), test);
		
		test.setNumber(1000);
		System.out.printf("%s is %s", test.getNumber(), test);
		
		test.setNumber(2500);
		System.out.printf("%s is %s", test.getNumber(), test);
		
		test.setNumber(1500);
		System.out.printf("%s is %s", test.getNumber(), test);
		
		test.setNumber(23);
		System.out.printf("%s is %s", test.getNumber(), test);
		
		test.setNumber(38);
		System.out.printf("%s is %s", test.getNumber(), test);
		
		test.setNumber(49);
		System.out.printf("%s is %s", test.getNumber(), test);
		
		test.setRoman("LXXVII");
		System.out.printf("%s is %s", test.getNumber(), test);
		
		test.setRoman("XLIX");
		System.out.printf("%s is %s", test.getNumber(), test);
		
		test.setRoman("XX");
		System.out.printf("%s is %s", test.getNumber(), test);
		
		test.setRoman("XXXVIII");
		System.out.printf("%s is %s", test.getNumber(), test);
	}
}