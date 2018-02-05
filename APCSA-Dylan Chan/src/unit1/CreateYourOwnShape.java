package unit1;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;

public class CreateYourOwnShape extends JPanel
{
	public CreateYourOwnShape()
	{
		JFrame window = new JFrame();
		window.add(this);
		window.setSize(640, 480);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void paint(Graphics window)
	{
		window.setColor(Color.BLUE);
		window.fillOval(100, 100, 100, 50);
		
		window.setColor(Color.GREEN);
		window.fillOval(125, 75, 50, 100);
		
		window.setColor(Color.RED);
		window.fillRect(300, 100, 100, 50);
		
		window.setColor(Color.YELLOW);
		window.fillRect(325, 75, 50, 100);
		
		window.setColor(Color.BLACK);
		window.drawLine(150, 200, 150, 300);
		window.drawLine(100, 250, 200, 250);
		window.drawLine(100, 200, 200, 300);
		window.drawLine(100, 300, 200, 200);
	}

	public static void main(String[] args) 
	{
		CreateYourOwnShape shape = new CreateYourOwnShape();

	}

}
