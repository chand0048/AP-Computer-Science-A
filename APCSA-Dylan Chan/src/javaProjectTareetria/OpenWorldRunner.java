package javaProjectTareetria;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.JOptionPane.*;


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
	
	public static void main(String[] args)
	{
		JOptionPane.showConfirmDialog(null,
				"Use WASD to move. Tool selected is shown in the bottom midle of the screen.\nUse the scroll wheel to switch between the rifle and the building tool.\nWhen the rifle is selected use LMB to fire. When the building tool is selected \nclick LMB on where you want to place a block and click RMB on an existing \nblock to remove it. Zombies will attack you. Try to survive for as long as \npossible by using a combination of building and shooting. Good luck!",
				"Instructions", JOptionPane.OK_OPTION);
		OpenWorldRunner run = new OpenWorldRunner();
	}
}
