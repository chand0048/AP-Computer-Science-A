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
   private boolean exitFound;

	public Maze()
	{
		maze = new int[0][0];
		
		usedR = new ArrayList<Integer>();
		usedC = new ArrayList<Integer>();
		
		exitFound = false;
	}

	public Maze(int size, String line)
	{
		maze = new int[size][size];
		
		usedR = new ArrayList<Integer>();
		usedC = new ArrayList<Integer>();
		
		exitFound = false;
		
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
		if (r >= 0 && r < maze.length && c >= 0 && c < maze.length && maze[r][c] == 1)
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
				exitFound = true;
				
				return true;
			}
			
			usedR.add(r);
			usedC.add(c);
			
			hasExitPath(r, c + 1);
			hasExitPath(r + 1, c);
			hasExitPath(r, c - 1);
			return hasExitPath(r - 1, c);
		}
		else
		{
			return false;
		}
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

		hasExitPath(0, 0);
		
		if (exitFound)
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