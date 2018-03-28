package elevensActivites;

import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensAssesment extends Board{

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};


	/**
	 * The cards on this board.
	 */
	private Card[] cards;

	/**
	 * The deck of cards being used to play the current game.
	 */
	private Deck deck;

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;

	public ElevensAssesment() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
		System.out.println("Dylan Chan, Period 4, 3/28/18, Computer 6");
	}

	public void newGame() {
		super.newGame();
	}

	public int size() {
		//return cards.length;
		return super.size();
	}

	public boolean isEmpty() {
		return super.isEmpty();
	}

	public void deal(int k) {
		//cards[k] = deck.deal();
		super.deal(k);
	}

	public int deckSize() {
		//return deck.size();
		return super.deckSize();
	}

	public Card cardAt(int k) {
		//return cards[k];
		return super.cardAt(k);
	}

	public void replaceSelectedCards(List<Integer> selectedCards) {
		super.replaceSelectedCards(selectedCards);
	}

	public List<Integer> cardIndexes() {
		return super.cardIndexes();
	}

	public String toString() {
		String s = "";
		for (int k = 0; k < cards.length; k++) {
			s = s + k + ": " + cards[k] + "\n";
		}
		return s;
	}

	public boolean gameIsWon() {
		if (deck.isEmpty()) {
			for (Card c : cards) {
				if (c != null) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean isLegal(List<Integer> selectedCards) {
		
		if (containsTripletSum11(selectedCards))
		{
			return true;
		}
		else if (containsFacePair(selectedCards))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		
		List<Integer> selectedCards = cardIndexes();
		
		if (containsTripletSum11(selectedCards))
		{
			return true;
		}
		else if (containsFacePair(selectedCards))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private void dealMyCards() {
		for (int k = 0; k < cards.length; k++) {
			cards[k] = deck.deal();
		}
	}

	boolean containsTripletSum11(List<Integer> selectedCards) {

		for (Integer index1: selectedCards)
		{
			for (Integer index2: selectedCards)
			{
				for (Integer index3: selectedCards)
				{
					if (cardAt(index1).pointValue() + cardAt(index2).pointValue() + cardAt(index3).pointValue() == 11)
					{
						return true;
					}
				}
			}	
		}
		
		return false;
	}

	private boolean containsFacePair(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */

		int queens = 0, kings = 0, jacks = 0;
		
		
		for (Integer num: selectedCards)
		{			
			if (cardAt(num).rank().equals("queen"))
			{
				queens++;
			}
			if (cardAt(num).rank().equals("king"))
			{
				kings++;
			}
			if (cardAt(num).rank().equals("jack"))
			{
				jacks++;
			}
			
		}
		
		if (queens == 2 || kings == 2 || jacks == 2)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}

