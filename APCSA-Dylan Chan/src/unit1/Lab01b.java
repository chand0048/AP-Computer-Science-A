package unit1;

import javax.swing.*;
import java.awt.*;

public class Lab01b extends JPanel
{

	public Lab01b()
	{
		JFrame window = new JFrame();
		window.add(this);
		window.setSize(640, 480);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
	}
	
	public void paint(Graphics window)
	{
		window.setColor(Color.BLACK);
		window.drawString("It\'s a smiley face!", 280, 100);
		window.setColor(Color.YELLOW);
		window.fillOval(170, 140, 300, 300);
		window.setColor(Color.BLACK);
		window.fillOval(250, 220, 30, 30);
		window.fillOval(360, 220, 30, 30);
		window.drawArc(230, 255, 180, 120, 200, 140);
	}
	
	public static void main(String[] args) 
	{
		Lab01b gui = new Lab01b();
	
	}

	
}
