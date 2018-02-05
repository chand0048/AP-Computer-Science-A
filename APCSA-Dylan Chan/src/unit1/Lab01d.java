package unit1;

import java.awt.*;
import javax.swing.*;

public class Lab01d extends JPanel
{
	
	public Lab01d()
	{
		JFrame window = new JFrame();
		
		window.add(this);
		window.setVisible(true);
		window.setSize(640, 480);
		window.setBackground(Color.WHITE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void paint(Graphics window)
	{
		window.setColor(Color.LIGHT_GRAY);
		window.fillRect(290, 90, 60, 60);
		window.fillRect(260, 150, 120, 150);
		
		window.setColor(Color.DARK_GRAY);
		window.drawArc(270, 300, 80, 180, 100, 90);
		window.drawArc(290, 300, 80, 180, 80, -90);
		window.drawArc(190, 180, 140, 220, 90, 110);
		window.drawArc(310, 180, 140, 220, 90, -110);
		
		window.setColor(Color.GREEN);
		window.fillOval(309, 105, 22, 30);
		
		window.setColor(Color.BLACK);
		window.fillOval(309, 115, 22, 10);
		window.drawString("This is my robot!", 275, 70);
		
	}

	public static void main(String[] args) 
	{
		Lab01d robot = new Lab01d();
	}

}
