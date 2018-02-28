package elevensActivites;

import java.util.List;
import java.util.ArrayList;


/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

	/**
	 * cards contains all the cards in the deck.
	 */
	//private List<Card> cards;
	
	//Unit 9 - Array version of the Deck
	
	private Card[] cards;

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size;

	
	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */
	public Deck(String[] ranks, String[] suits, int[] values) 
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		cards = new Card[52];
		int index = 0;
		
		for (int suitIndex = 0; suitIndex < suits.length; suitIndex++)
		{
			for (int rankIndex = 0; rankIndex < ranks.length; rankIndex++)
			{
				Card card = new Card(ranks[rankIndex], suits[suitIndex], values[rankIndex]);
				cards[index] = card;
				
				index++;
			}
		}
		
		shuffle();
	}
		

	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() 
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		if (size == 0)
		{
			return true;
		}
		else
		{ 
			return false;
		}
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() 
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		return size;
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() 
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
		for (int index = cards.length - 1; index >= 0; index++)
		{
			int randIndex = (int) Math.ceil(Math.random() * (cards.length - 1));
			
			Card temp = cards[index];
			cards[index] = cards[randIndex];
			cards[randIndex] = temp;
			
			size = cards.length;
		}
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() 
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		int randomIndex;
		
		if (isEmpty() == true)
		{
			return null;
		}
		else
		{
			Card dealt = cards[size - 1];
			size--;
			return dealt;
		}
	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() 
	{
		String rtn = "size = " + size + "\nUndealt cards: \n";


		//Unit 9 - modify to work with Arrays
		/*
		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}
		*/
		for (int index = size - 1; index >= 0; index--)
		{
			rtn += cards[index].toString();
			if (index != 0) 
			{
				rtn = rtn + ", ";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
	
}
