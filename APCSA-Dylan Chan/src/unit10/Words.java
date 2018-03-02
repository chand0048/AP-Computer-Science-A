package unit10;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Words
{
	private ArrayList<Word> words;

	public Words()
	{
		setWords("");
	}

	public Words(String wordList)
	{
		int psn = 0;
		words = new ArrayList();
		
		while (psn < wordList.length())
		{
			if (wordList.indexOf(" ", psn) >= 0)
			{
				Word word = new Word(wordList.substring(psn, wordList.indexOf(" ", psn)));
				words.add(word);
				psn = wordList.indexOf(" ", psn) + 1;
			}
			else
			{
				psn++;
			}
		}
	}

	public void setWords(String wordList)
	{
		int psn = 0;
		words = new ArrayList();
		
		while (psn != wordList.length())
		{
			if (wordList.indexOf(" ", psn) >= 0)
			{
				psn = wordList.indexOf(" ", psn);
				Word word = new Word(wordList.substring(psn, wordList.indexOf(" ", psn)));
				words.add(word);
			}
			else
			{
				psn++;
			}
		}
	}
	
	public int countWordsWithXChars(int size)
	{
		int count=0;
		for (Word item: words)
		{
			if (item.getLength() == size)
			{
				count++;
			}
		}

		return count;
	}
	
	//this method will remove all words with a specified size / length
	//this method will also return the sum of the vowels in all words removed
	public int removeWordsWithXChars(int size)
	{
		int numVowels = 0;
		for (Word item: words)
		{
			if (item.getLength() == size)
			{
				numVowels += item.getNumVowels();
				words.remove(item);
			}
		}
		
		return numVowels;
	}

	public int countWordsWithXVowels(int numVowels)
	{
		int count=0;
		for (Word item: words)
		{
			if (item.getNumVowels() == numVowels)
			{
				count++;
			}
		}

		return count;
	}
	
	public String toString()
	{
	   return "";
	}
}
