package unit10Lab16d;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	
	public MadLib()
	{



	}

	public MadLib(String fileName)
	{
		//load stuff
		verbs = new ArrayList();
		nouns = new ArrayList();
		adjectives = new ArrayList();
		
		loadNouns();
		loadVerbs();
		loadAdjectives();	
		
		try{
			Scanner file = new Scanner(new File(System.getProperty(fileName)));
		
		
		
		
		
		
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
	}

	public void loadNouns()
	{
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir") + "\\src\\unit10Lab16d\\nouns.dat"));
			while (file.hasNextLine())
			{
				nouns.add(file.nextLine());
			}
		}
		
		catch(Exception e)
		{
			out.println(e);
		}	
		
	}
	
	public void loadVerbs()
	{
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir") + "\\src\\unit10Lab16d\\verbs.dat"));
			while (file.hasNextLine())
			{
				verbs.add(file.nextLine());
			}
					
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

	public void loadAdjectives()
	{
		try{
			Scanner file = new Scanner(new File(System.getProperty("user.dir") + "\\src\\unit10Lab16d\\adjectives.dat"));
			while (file.hasNextLine())
			{
				adjectives.add(file.nextLine());
			}
	
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

	public String getRandomVerb()
	{
		String word = verbs.get((int) Math.ceil(Math.random() * verbs.size()));
		return "";
	}
	
	public String getRandomNoun()
	{
		
		return "";
	}
	
	public String getRandomAdjective()
	{
		
		return "";
	}		

	public String toString()
	{
	   return "\n\n\n";
	}
}