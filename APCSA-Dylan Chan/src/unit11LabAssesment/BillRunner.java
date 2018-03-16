package unit11LabAssesment;

public class BillRunner {

	public static void main(String[] args) 
	{
		Bill test = new Bill("March");
		
		ShoppingList hardwareList = new ShoppingList("Hardware Store");
		
		hardwareList.addProduct(new Product("Hammer", 7.99));
		hardwareList.addProduct(new Product("Piping", 21.73));
		hardwareList.addProduct(new Product("2x4 Wood Boards", 16.32));
		
		ShoppingList groceriesList = new ShoppingList("Groceries");
		groceriesList.addProduct(new Product("Apples", 6.78));
		groceriesList.addProduct(new Product("Milk", 4.56));
		groceriesList.addProduct(new Product("Eggs", 5.99));
		groceriesList.addProduct(new Product("Cereal", 8.53));
		
		test.addList(hardwareList);
		test.addList(groceriesList);
		
		System.out.println(test);

	}

}
