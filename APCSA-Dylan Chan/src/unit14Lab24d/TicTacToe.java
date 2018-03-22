package unit14Lab24d;

import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;

	public TicTacToe()
	{
		mat = new char[0][0];

	}

	public TicTacToe(String game)
	{
		mat = new char[3][3];
		
		int psn = 0;
		
		for (int y = 0; y < mat.length; y++)
		{
			for (int x = 0; x < mat.length; x++)
			{
				mat[y][x] = game.charAt(psn);
				psn++;
			}
		}
	}

	public String getWinner()
	{		
		for (int row = 0; row < mat.length; row++)
		{
			int numX = 0;
			
			for (int x = 0; x < mat.length; x++)
			{
				if (mat[row][x] == 'X')
				{
					numX++;
				}
			}
			
			if (numX == 3)
			{
				return "X wins horizontally!";
			}
			
			if (numX == 0)
			{
				return "O wins horizontally!";
			}
		}
		
		for (int column = 0; column < mat.length; column++)
		{
			int numX = 0;
			
			for (int y = 0; y < mat.length; y++)
			{
				if (mat[y][column] == 'X')
				{
					numX++;
				}
			}
			
			if (numX == 3)
			{
				return "X wins vertically!";
			}
			
			if (numX == 0)
			{
				return "O wins vertically!";
			}
		}
		
		int topLeftX = 0, topRightX = 0;
		int column = 0;
		
		for (int row = 0; row < mat.length; row++)
		{
			if (mat[row][column] == 'X')
			{
				topLeftX++;
			}
			
			if (mat[row][mat.length - 1 - column] == 'X')
			{
				topRightX++;
			}
			
			column++;
		}
		
		if (topLeftX == 3)
		{
			return "X wins diagonally!";
		}
		else if (topLeftX == 0)
		{
			return "O wins diagonally!";
		}
		else if (topRightX == 3)
		{
			return "X wins diagonally!";
		}
		else if (topRightX == 0)
		{
			return "O wins diagonally!";
		}
		
		return "It was a draw, no one won!";
	}

	public String toString()
	{
		String output="";
		
		for (int y = 0; y < mat.length; y++)
		{
			for (int x = 0; x < mat.length; x++)
			{
				output += mat[y][x];
			}
			
			output += "\n";
		}
		
		output += getWinner();

		return output+"\n\n";
	}
}
