package unit14;

import static java.lang.System.*;
import java.util.ArrayList;

public class AtCounter
{
   private char[][] atMat;
   private int atCount;
   private ArrayList<Integer> usedR, usedC;

	public AtCounter()
	{
		atCount = 0;
		usedR = new ArrayList<Integer>();
		usedC = new ArrayList<Integer>();
		atMat = new char[][]{{'@','-','@','-','-','@','-','@','@','@'},
									{'@','@','@','-','@','@','-','@','-','@'},
									{'-','-','-','-','-','-','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','-','@'},
									{'-','@','-','@','-','@','-','@','-','@'},
									{'@','@','@','@','@','@','-','@','@','@'},
									{'-','@','-','@','-','@','-','-','-','@'},
									{'-','@','@','@','-','@','-','-','-','-'},
									{'-','@','-','@','-','@','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','@','@'}};
	}

	public int countAts(int r, int c)
	{

		//add in recursive code to count up the # of @s connected
		//start checking at spot [r,c]
		
		if (r >= 0 && r < 10 && c >= 0 && c < 10 && atMat[r][c] == '@')
		{
			for (int index = 0; index < usedR.size(); index++)
			{
				if (usedR.get(index) == r && usedC.get(index) == c)
				{
					return 0;
				}
			}
			
			atCount++;
			usedR.add(r);
			usedC.add(c);
			countAts(r, (c - 1));
			countAts(r, (c + 1));
			countAts((r - 1), c);
			return countAts((r + 1), c);
		}
		
		else
		{
			return 0;
		}
	}

	public int getAtCount()
	{
		return atCount;
	}

	public String toString()
	{
		String output="";
		output+=getAtCount()+" @s connected.";
		
		atCount = 0;
		usedR = new ArrayList<Integer>();
		usedC = new ArrayList<Integer>();
		return output;
	}
}