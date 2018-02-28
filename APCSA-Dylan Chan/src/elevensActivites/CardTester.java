package elevensActivites;

public class CardTester 
{
	public static void main(String[] args)
	{
		Card card1 = new Card("King", "Hearts", 10);
		Card card2 = new Card("Ace", "Spades", 1);
		Card card3 = new Card("Seven", "Spades", 7);
		
		System.out.println(card1.suit());
		System.out.println(card1.rank());
		System.out.println(card1.pointValue());
		System.out.println(card1.matches(new Card("King", "Hearts", 10)));
		System.out.println(card1);
		System.out.println();
		
		System.out.println(card2.suit());
		System.out.println(card2.rank());
		System.out.println(card2.pointValue());
		System.out.println(card2.matches(new Card("King", "Hearts", 10)));
		System.out.println(card2);
		System.out.println();
		
		System.out.println(card3.suit());
		System.out.println(card3.rank());
		System.out.println(card3.pointValue());
		System.out.println(card3.matches(new Card("King", "Hearts", 10)));
		System.out.println(card3);
		System.out.println();
		
	}
}
