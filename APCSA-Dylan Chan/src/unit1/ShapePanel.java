package unit1;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapePanel extends JPanel
{
	public ShapePanel()
	{
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	/*
	 *All of your test code should be placed in paint.
	 */
	public void paint(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.BLUE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("CREATE YOUR OWN SHAPE!",40,40);


		Shape ovalCross = new Shape(100, 100, 100, 50, Color.BLUE);
		ovalCross.drawOval(window);
		ovalCross.set(125, 75, 50, 100, Color.GREEN);
		ovalCross.drawOval(window);
		
		Shape rectCross = new Shape(300, 100, 100, 50, Color.RED);
		rectCross.drawRect(window);
		rectCross.set(325, 75, 50, 100, Color.YELLOW);
		rectCross.drawRect(window);

		Shape star = new Shape(100, 200, 100, 100, Color.ORANGE);
		star.drawStar(window);
		
		
		window.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 12));
		window.setColor(Color.BLACK);
		window.drawString("This is an oval-cross", 100, 70);
		window.drawString("This is a rectangle-cross", 300, 70);
		window.drawString("This is a star", 100, 190);
	}
}