package elevensActivites;

import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board{

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


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensBoard() {
		//cards = new Card[BOARD_SIZE];
		//deck = new Deck(RANKS, SUITS, POINT_VALUES);
		//if (I_AM_DEBUGGING) {
		//	System.out.println(deck);
		//	System.out.println("----------");
		//}
		//dealMyCards();
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}

	/**
	 * Start a new game by shuffling the deck and
	 * dealing some cards to this board.
	 */
	public void newGame() {
		//deck.shuffle();
		//dealMyCards();
		super.newGame();
	}

	/**
	 * Accesses the size of the board.
	 * Note that this is not the number of cards it contains,
	 * which will be smaller near the end of a winning game.
	 * @return the size of the board
	 */
	public int size() {
		//return cards.length;
		return super.size();
	}

	/**
	 * Determines if the board is empty (has no cards).
	 * @return true if this board is empty; false otherwise.
	 */
	public boolean isEmpty() {
		//for (int k = 0; k < cards.length; k++) {
		//	if (cards[k] != null) {
		//		return false;
		//	}
		//}
		//return true;
		return super.isEmpty();
	}

	/**
	 * Deal a card to the kth position in this board.
	 * If the deck is empty, the kth card is set to null.
	 * @param k the index of the card to be dealt.
	 */
	public void deal(int k) {
		//cards[k] = deck.deal();
		super.deal(k);
	}

	/**
	 * Accesses the deck's size.
	 * @return the number of undealt cards left in the deck.
	 */
	public int deckSize() {
		//return deck.size();
		return super.deckSize();
	}

	/**
	 * Accesses a card on the board.
	 * @return the card at position k on the board.
	 * @param k is the board position of the card to return.
	 */
	public Card cardAt(int k) {
		//return cards[k];
		return super.cardAt(k);
	}

	/**
	 * Replaces selected cards on the board by dealing new cards.
	 * @param selectedCards is a list of the indices of the
	 *        cards to be replaced.
	 */
	public void replaceSelectedCards(List<Integer> selectedCards) {
		//for (Integer k : selectedCards) {
		//	deal(k.intValue());
		//}
		super.replaceSelectedCards(selectedCards);
	}

	/**
	 * Gets the indexes of the actual (non-null) cards on the board.
	 *
	 * @return a List that contains the locations (indexes)
	 *         of the non-null entries on the board.
	 */
	public List<Integer> cardIndexes() {
		//List<Integer> selected = new ArrayList<Integer>();
		//for (int k = 0; k < cards.length; k++) {
		//	if (cards[k] != null) {
		//		selected.add(new Integer(k));
		//	}
		//}
		//return selected;
		
		return super.cardIndexes();
	}

	/**
	 * Generates and returns a string representation of this board.
	 * @return the string version of this board.
	 */
	public String toString() {
		String s = "";
		for (int k = 0; k < cards.length; k++) {
			s = s + k + ": " + cards[k] + "\n";
		}
		return s;
	}

	/**
	 * Determine whether or not the game has been won,
	 * i.e. neither the board nor the deck has any more cards.
	 * @return true when the current game has been won;
	 *         false otherwise.
	 */
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

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		
		if (containsPairSum11(selectedCards))
		{
			return true;
		}
		else if (containsJQK(selectedCards))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		
		List<Integer> selectedCards = cardIndexes();
		
		if (containsPairSum11(selectedCards))
		{
			return true;
		}
		else if (containsJQK(selectedCards))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Deal cards to this board to start the game.
	 */
	private void dealMyCards() {
		for (int k = 0; k < cards.length; k++) {
			cards[k] = deck.deal();
		}
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */

		for (Integer index1: selectedCards)
		{
			for (Integer index2: selectedCards)
			{
				if (cardAt(index1).pointValue() + cardAt(index2).pointValue() == 11)
				{
					return true;
				}
			}	
		}
		
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */

		boolean queenSelected = false, kingSelected = false, jackSelected = false;
		
		
		for (Integer num: selectedCards)
		{			
			if (cardAt(num).rank().equals("queen"))
			{
				queenSelected = true;
			}
			if (cardAt(num).rank().equals("king"))
			{
				kingSelected = true;
			}
			if (cardAt(num).rank().equals("jack"))
			{
				jackSelected = true;
			}
			
		}
		
		if (queenSelected == true && kingSelected == true && jackSelected == true)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
