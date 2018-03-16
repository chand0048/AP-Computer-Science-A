package unit11LabAssesment;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class ShoppingList 
{
	private ArrayList<Product> shoppingList;
	private String listName;	
	
	public ShoppingList()
	{
		shoppingList = new ArrayList<Product>();
		setListName("");
	}
	
	public ShoppingList(String name)
	{
		shoppingList = new ArrayList<Product>();
		setListName(name);
	}
	
	public void setListName(String name)
	{
		listName = name;
	}
	
	public void addProduct(Product item)
	{
		shoppingList.add(item);
	}
	
	public String getListName()
	{
		return listName;
	}
	
	public Product getProduct(int index)
	{
		return shoppingList.get(index);
	}
	
	public double getTotalCost()
	{
		double total = 0;
		
		for (Product item: shoppingList)
		{
			total += item.getCost();
		}
		
		return total;
	}
	
	public String toString()
	{
		String output = "";
		
		output += getListName() + " - Shopping List\n";
		
		for (Product item: shoppingList)
		{
			output += item + "\n";
		}
		
		DecimalFormat df = new DecimalFormat("#.00");
		output += "\nTOTAL COST = $" + df.format(getTotalCost());
		
		return output;
	}
}
