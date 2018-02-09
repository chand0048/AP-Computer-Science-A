package unit1;

import java.awt.Color;
import java.awt.Graphics;

public class Shape
{
   //instance variables
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;

   public Shape(int x, int y, int wid, int ht, Color col)
   {
		xPos = x;
		yPos = y;
		width = wid;
		height = ht;
		color = col;
   }
   
   public void set(int x, int y, int wid, int ht, Color col)
   {
	   xPos = x;
	   yPos = y;
	   width = wid;
	   height = ht;
	   color = col;
   }

   public void drawRect(Graphics window)
   {
      window.setColor(color);
      window.fillRect(xPos, yPos, width, height);
   }
   
   public void drawOval(Graphics window)
   {
	   window.setColor(color);
	   window.fillOval(xPos, yPos, width, height);
   }
   
   public void drawStar(Graphics window)
   {
	   window.setColor(color);
	   window.drawLine(xPos, yPos, xPos + width, yPos + height);
	   window.drawLine(xPos + width, yPos, xPos, yPos + height);
	   window.drawLine(xPos + (int) (0.5 * width), yPos, xPos + (int) (0.5 * width), yPos + height);
	   window.drawLine(xPos, yPos + (int) (0.5 * height), xPos + width, yPos + (int) (0.5 * height));
   }

   //BONUS
   //add in set and get methods for all instance variables

   public String toString()
   {
   	return xPos+" "+yPos+" "+width+" "+height+" "+color;
   }
}