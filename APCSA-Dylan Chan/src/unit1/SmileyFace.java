package unit1;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import javax.swing.*;

public class SmileyFace extends Canvas
{
   public SmileyFace()    //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      smileyFace(window);
   }

   public void smileyFace( Graphics window )
   {
	   window.setColor(Color.BLACK);
		window.drawString("It\'s a smiley face!", 280, 100);
		
		window.setColor(Color.YELLOW);
		window.fillOval(170, 140, 300, 300);
		
		window.setColor(Color.BLACK);
		window.fillOval(250, 220, 30, 30);
		window.fillOval(360, 220, 30, 30);
		window.drawArc(230, 255, 180, 120, 200, 140);

		//add more code here


   }
}