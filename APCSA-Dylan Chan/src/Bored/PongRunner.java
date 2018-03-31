package Bored;

import javax.swing.JFrame;
import java.awt.Component;


public class PongRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 700;

	public PongRunner()
	{
		super("PONG");
		setSize(WIDTH, HEIGHT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		UltimatePong game = new UltimatePong();

		((Component) game).setFocusable(true);
		getContentPane().add(game);

		setVisible(true);
	}

	public static void main(String args[])
	{
		PongRunner run = new PongRunner();
	}
}

