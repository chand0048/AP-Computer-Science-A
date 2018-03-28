package elevensActivites;

public class ElevensAssesmentRunner {
	public static void main(String[] args) {
		Board board = new ElevensAssesment();
		CardGameGUI gui = new CardGameGUI(board);
		gui.displayGame();
	}
}
