package unit6;

import static java.lang.System.*;

public class LoopStats
{
	private int start, stop;

	public LoopStats()
	{


	}

	public LoopStats(int beg, int end)
	{
		start = beg;
		stop = end;
	}

	public void setNums(int beg, int end)
	{
		start = beg;
		stop = end;
	}

	public int getEvenCount()
	{
		int evenCount=0;
		for (int counter = start; counter <= stop; counter++)
		{
			if (counter % 2 == 0)
			{
				evenCount++;
			}
		}
		return evenCount;
	}

	public int getOddCount()
	{
		int oddCount=0;
		for (int counter = start; counter <= stop; counter++)
		{
			if (counter % 2 != 0)
			{
				oddCount++;
			}
		}
		return oddCount;
	}

	public int getTotal()
	{
		int total=0;
		for (int counter = start; counter <= stop; counter++)
		{
			total += counter;
		}
		return total;
	}
	
	public String toString()
	{
		return start + " " + stop + "\ntotal " + getTotal() + "\nevencount " + getEvenCount() + "\nodd count " + getOddCount() + "\n";
	}
}