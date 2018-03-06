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
		//load stuff
		verbs = new ArrayList();
		nouns = new ArrayList();
		adjectives = new ArrayList();
		
		loadNouns();
		loadVerbs();
		loadAdjectives();	
		
		
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
		String word = verbs.get((int) Math.floor(Math.random() * verbs.size()));
		return word;
	}
	
	public String getRandomNoun()
	{
		String word = nouns.get((int) Math.floor(Math.random() * nouns.size()));
		return word;
	}
	
	public String getRandomAdjective()
	{
		String word = adjectives.get((int) Math.floor(Math.random() * adjectives.size()));
		return word;
	}		

	public String toString()
	{	
		String madlib = "";
		try
		{
			Scanner file = new Scanner(new File(System.getProperty("user.dir") + "\\src\\unit10lab16d\\story.dat"));
			
			String line = file.nextLine();
			file.close();
			
			int psn = 0;
			while (psn < line.length())
			{
				if (line.substring(psn, psn + 1).equals("#"))
				{
					madlib += getRandomNoun();
					psn++;
				}
				else if (line.substring(psn, psn + 1).equals("@"))
				{
					madlib += getRandomVerb();
					psn++;
				}
				else if (line.substring(psn, psn + 1).equals("&"))
				{
					madlib += getRandomAdjective();
					psn++;
				}
				else
				{
					madlib += line.substring(psn, psn + 1);
					psn++;
				}
			}
		}
		catch (Exception e)
		{
			out.println(e);
		}
		
		
		
		return madlib;
	}
}