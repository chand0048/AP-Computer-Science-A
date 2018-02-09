package unit1;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
   public Robot()    //constructor method - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);   	
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      window.setColor(Color.BLUE);

      window.drawString("Robot LAB ", 35, 35 );

      head(window);
      
      upperBody(window);
      
      lowerBody(window);
      
   }

   public void head( Graphics window )
   {
	   window.setColor(Color.LIGHT_GRAY);
	   window.fillRect(290, 90, 60, 60);
	   window.setColor(Color.GREEN);
	   window.fillOval(309, 105, 22, 30);
		
	   window.setColor(Color.BLACK);
	   window.fillOval(309, 115, 22, 10);
				
   }

   public void upperBody( Graphics window )
   {
	   window.setColor(Color.LIGHT_GRAY);
	   window.fillRect(260, 150, 120, 150);
	   
	   window.setColor(Color.DARK_GRAY);
	   window.drawArc(190, 180, 140, 220, 90, 110);
	   window.drawArc(310, 180, 140, 220, 90, -110);
   }

   public void lowerBody( Graphics window )
   {
	   window.setColor(Color.DARK_GRAY);
	   window.drawArc(270, 300, 80, 180, 100, 90);
	   window.drawArc(290, 300, 80, 180, 80, -90);

   }
}