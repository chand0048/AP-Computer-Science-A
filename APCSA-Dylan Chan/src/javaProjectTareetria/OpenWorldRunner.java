package javaProjectTareetria;

import javax.swing.JFrame;
import java.awt.Component;

public class OpenWorldRunner extends JFrame
{
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 800;
	
	public OpenWorldRunner()
	{
		super("Tareetria");
		setSize(WIDTH, HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Tareetria game = new Tareetria();
		
		((Component) game).setFocusable(true);
		getContentPane().add(game);
		

		setVisible(true);
	}
	public static void main(String [] args)
	{
		OpenWorldRunner run = new OpenWorldRunner();
	}
}
