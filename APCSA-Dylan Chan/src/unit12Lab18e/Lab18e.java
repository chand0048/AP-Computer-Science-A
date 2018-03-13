package unit12Lab18e;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class Lab18e
{
	public static void main( String args[] ) throws IOException
	{
		try
		{
			Scanner file = new Scanner(new File(System.getProperty("user.dir") + "\\src\\unit12Lab18e\\lab18e.dat"));
			
			int size = file.nextInt();
			file.nextLine();
		}
		catch (Exception e)
		{
			out.println(e);
		}
	}
}