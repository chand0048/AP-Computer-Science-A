package unit14Lab24d;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab24d
{
	public static void main( String args[] ) throws IOException
	{
		try
		{
			Scanner file = new Scanner (new File(System.getProperty("user.dir") + "\\src\\unit14Lab24d\\lab24d.dat"));

			int size = file.nextInt();
			file.nextLine();
			
			for (int counter = 0; counter < size; counter++)
			{
				TicTacToe testLine = new TicTacToe(file.nextLine());
				
				out.println(testLine);
			}
		}
		catch (Exception e)
		{
			out.println(e);
		}







	}
}
