package midtermStudy;

public class Tester 
{
	public static void main(String [] args)
	{
		TotalItUp test1 = new TotalItUp();
		test1.setNums(32,21);
		test1.add();	
		test1.print();

		test1.setNums(15,8);
		test1.add();	
		test1.print();

		
		CompareNums test2 = new CompareNums(32,32);
		System.out.println(test2);

		test2.setNums(15,8);
		System.out.println(test2);
		
		
		Table table = new Table(10,5);
		table.print();


	}

}
