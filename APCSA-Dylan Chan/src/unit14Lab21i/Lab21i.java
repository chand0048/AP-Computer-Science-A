package unit14Lab21i;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab21i
{
	public static void main( String args[] ) throws IOException
	{
		try
		{
			Scanner file = new Scanner(new File(System.getProperty("user.dir") + "\\src\\unit14Lab21i\\lab21i.dat"));
			
			while (file.hasNextLine())
			{
				int size = file.nextInt();
				file.nextLine();
				String line = file.nextLine();
				
				Maze tempRun = new Maze(size, line);
				out.println(tempRun);
			}
			
		}
		catch (Exception e)
		{ 
			out.println(e);
		}
	}
}
