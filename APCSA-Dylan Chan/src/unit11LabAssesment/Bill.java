package unit11LabAssesment;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class Bill 
{
	private ArrayList<ShoppingList> bill;
	private String month;
	
	public Bill()
	{
		bill = new ArrayList<ShoppingList>();
		setMonth("");
	}
	
	public Bill(String name)
	{
		bill = new ArrayList<ShoppingList>();
		setMonth(name);
	}
	public void setMonth(String name)
	{
		month = name;
	}
	
	public void addList(ShoppingList list)
	{
		bill.add(list);
	}
	
	public String getMonth()
	{
		return month;
	}
	
	public ShoppingList getList(int index)
	{
		return bill.get(index);
	}
	
	public double getTotalBill()
	{
		double total = 0;
		
		for (ShoppingList list: bill)
		{
			total += list.getTotalCost();
		}
		
		return total;
	}
	
	public String toString()
	{
		String output = "";
		
		output += getMonth() + "\'s Bill\n\n";
		
		for (ShoppingList list: bill)
		{
			output += list + "\n\n";
		}
		
		DecimalFormat df = new DecimalFormat("#.00");
		output += "\nTOTAL BILL COST = $" + df.format(getTotalBill());
		
		return output;
	}
}
