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
		String madlib = "Come " + getRandomVerb() + " at WALMART, where you`ll "
				+ "receive " + getRandomAdjective() + " discounts on all \nof your favorite "
						+ "brand name " + getRandomNoun() + "s. Our " + getRandomAdjective() + 
						" and " + getRandomVerb() + " associates \nare there to " + getRandomVerb() + 
						" you 12 hours a day. Here you will find " + getRandomAdjective() + " \nprices on the " + 
						getRandomNoun() + "s you need. " + getRandomNoun() + "s for the moms, and " + getRandomNoun() + 
						"s \nfor the kids. So come on down to your " + getRandomAdjective() + " " + getRandomAdjective() + 
						" WALMART \nwhere the " + getRandomNoun() + "s come first.";
		return madlib;
	}
}