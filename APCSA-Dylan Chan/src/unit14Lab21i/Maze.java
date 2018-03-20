package unit14Lab21i;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.System.*;

public class Maze
{
   private int[][] maze;
   private ArrayList<Integer> usedR, usedC;

	public Maze()
	{
		maze = new int[0][0];
	}

	public Maze(int size, String line)
	{
		maze = new int[size][size];
		
		int psn = 0;
		
		for (int row = 0; row < size; row++)
		{
			for (int column = 0; column < size; column++)
			{
				if (psn == line.length() - 1)
				{
					maze[row][column] = Integer.parseInt(line.substring(psn));
				}
				else
				{
					maze[row][column] = Integer.parseInt(line.substring(psn, psn + 1));
				
					psn += 2;
				}
			}
		}
	}

	public boolean hasExitPath(int r, int c)
	{
		if (maze[r][c] == 1 && r >= 0 && r < maze.length && c >= 0 && c < maze.length)
		{
			for (int index = 0; index < usedR.size(); index++)
			{
				if (r == usedR.get(index) && c == usedC.get(index))
				{
					return false;
				}
			}
			if (c == maze.length - 1)
			{
				return true;
			}
			
			usedR.add(r);
			usedC.add(c);
			
			hasExitPath(r, c + 1);
			hasExitPath(r + 1, c);
			hasExitPath(r, c - 1);
			hasExitPath(r - 1, c);
		}
		
		return false;
		
	}

	public String toString()
	{
		String output="";
		
		for (int row = 0; row < maze.length; row++)
		{
			for (int column = 0; column < maze.length; column++)
			{
				output += maze[row][column] + " ";
			}
			output += "\n";
		}
		
		usedR = new ArrayList<Integer>();
		usedC = new ArrayList<Integer>();
		
		if (hasExitPath(0, 0))
		{
			output += "exit found\n";
		}
		else
		{
			output += "exit not found\n";
		}

		return output;
	}
}