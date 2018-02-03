package unit1;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class Lab01b extends JFrame
{
	public Lab01b()
	{
		setSize(640, 480);
		setBackground(Color.WHITE);
		setVisible(true);
	}
	public void paint(Graphics window)
	{
		window.setColor(Color.BLACK);
	}
	public static void main(String[] args) 
	{
		Lab01b window = new Lab01b();

		
	}

	
}
