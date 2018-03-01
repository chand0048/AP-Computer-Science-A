package elevensActivites;

public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		final String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		final int[] pointValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
		
		Deck deck1 = new Deck(ranks, suits, pointValues);
		Deck deck2 = new Deck(ranks, suits, pointValues);
		Deck deck3 = new Deck(ranks, suits, pointValues);
		
		
		System.out.println(deck1.isEmpty());
		System.out.println(deck1.size());
		System.out.println(deck1.deal());
		System.out.println(deck1);
		
		
		System.out.println("\n\n\n");
		for (int counter = 0; counter < 10; counter++)
		{
			System.out.println(deck2.deal());
		}
		System.out.println(deck2.isEmpty());
		System.out.println(deck2);
		
		
		System.out.println("\n\n\n");
		while (!deck3.isEmpty())
		{
			System.out.println(deck3.deal());
		}
		System.out.println(deck3.isEmpty());
		System.out.println(deck3);
		
	}
}