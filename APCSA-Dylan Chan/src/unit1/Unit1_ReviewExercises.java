package unit1;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Unit1_ReviewExercises extends JPanel
{

	
	public Unit1_ReviewExercises()
	{
		JFrame window = new JFrame();
		window.add(this);
		window.setSize(640, 480);
		window.setVisible(true);
		window.setBackground(Color.WHITE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void paint(Graphics window)
	{
		//Exercise 1
		Rectangle r = new Rectangle(220, 105, 12, 9);
		Rectangle t = new Rectangle(220, 135, 7, 6);
		window.setColor(Color.BLACK);
		window.fillRect((int) r.getX(), (int) r.getY(), (int) r.getWidth(), (int) r.getHeight());
		window.fillRect((int) t.getX(), (int) t.getY(), (int) t.getWidth(), (int) t.getHeight());
		window.drawString("Rectangle r: Width = " + r.getWidth() + ", Length = " + r.getHeight(), 200, 100);
		window.drawString("Rectangle t: Width = " + t.getWidth() + ", Length = " + t.getHeight(), 200, 130);
	}
	public static void main(String[] args) 
	{
		//Exercise 1
		Unit1_ReviewExercises shape = new Unit1_ReviewExercises();
		
		//Exercise 2
		String ex2 = "Hello World!";
		ex2 = ex2.replace("o", "e");
		ex2 = ex2.replaceFirst("e", "o");
		System.out.println(ex2);
		
		//Exercise 3
		Random rand = new Random();
		System.out.printf("Dice Roll: %s", rand.nextInt(5) + 1);

	}

}
