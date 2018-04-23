package starfighter;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	
	
	private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots;
	
	private int score;
	
	private boolean[] keys;
	private BufferedImage back;
	
	public OuterSpace()
	{
		setBackground(Color.black);
		
		keys = new boolean[6];
		
		aliens = new ArrayList<Alien>();
		
		
		for (int index = 0; index < 4; index++)
		{
			aliens.add(new Alien(-10 + (index * 140), 0, 2, "RIGHT"));
		}
		
		shots = new ArrayList<Ammo>();
		
		ship = new Ship(360, 260, 3);
		
		score = 0;
		
		this.addKeyListener(this);
		new Thread(this).start();
		
		setVisible(true);
	}
	
	public void update(Graphics window)
	{
		paint(window);
	}
	
	public void paint(Graphics window)
	{
		// set up the double buffering to make the game animation nice and
		// smooth
		Graphics2D twoDGraph = (Graphics2D) window;
		
		// take a snap shop of the current screen and same it as an image
		// that is the exact same width and height as the current screen
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));
			
		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		
		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50);
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0, 0, 800, 600);
		graphToBack.setColor(Color.WHITE);
		graphToBack.drawString("Score: " + score, 260, 20);
		
		ship.draw(graphToBack);
		
		
		for (int index = 0; index < aliens.size(); index++)
		{
			aliens.get(index).draw(graphToBack);
			aliens.get(index).move(aliens.get(index).getDirection());
			
			
			if (aliens.get(index).getX() <= -10 + (index * 140))
			{
				if (aliens.get(index).getDirection().equals("LEFT"))
				{
					aliens.get(index).setDirection("RIGHT");
				}
				else if (aliens.get(index).getDirection().equals("RIGHT"))
				{
					aliens.get(index).setDirection("LEFT");
				}
			}
			else if (aliens.get(index).getX() >= 290 + (index * 140))
			{
				if (aliens.get(index).getDirection().equals("LEFT"))
				{
					aliens.get(index).setDirection("RIGHT");
				}
				else if (aliens.get(index).getDirection().equals("RIGHT"))
				{
					aliens.get(index).setDirection("LEFT");
				}
			}
			
			/*
			if (aliens.get(index).getX() >= 710)
			{
				aliens.get(index).setDirection("LEFT");
			}
			else if (aliens.get(index).getX() <= -10)
			{
				aliens.get(index).setDirection("RIGHT");
			}
			else if (index > 0 && index < aliens.size() - 1
					&& (Math.abs(
							aliens.get(index).getX() - aliens.get(index - 1).getX()) < 140
							|| Math.abs(aliens.get(index).getX()
									- aliens.get(index + 1).getX()) < 140))
			{
				if (aliens.get(index).getDirection().equals("LEFT"))
				{
					aliens.get(index).setDirection("RIGHT");
				}
				else if (aliens.get(index).getDirection().equals("RIGHT"))
				{
					aliens.get(index).setDirection("LEFT");
				}
			}
			else if (aliens.size() > 1 && index == 0 && Math
					.abs(aliens.get(index).getX() - aliens.get(index + 1).getX()) < 140)
			{
				if (aliens.get(index).getDirection().equals("LEFT"))
				{
					aliens.get(index).setDirection("RIGHT");
				}
				else if (aliens.get(index).getDirection().equals("RIGHT"))
				{
					aliens.get(index).setDirection("LEFT");
				}
			}
			else if (aliens.size() > 1 && index == aliens.size() - 1 && Math
					.abs(aliens.get(index).getX() - aliens.get(index - 1).getX()) < 140)
			{
				if (aliens.get(index).getDirection().equals("LEFT"))
				{
					aliens.get(index).setDirection("RIGHT");
				}
				else if (aliens.get(index).getDirection().equals("RIGHT"))
				{
					aliens.get(index).setDirection("LEFT");
				}
			}
			*/
			
			for (int count = 0; count < shots.size(); count++)
			{
				if (shots.get(count).getY() <= aliens.get(index).getY() + 80
						&& shots.get(count).getY() >= aliens.get(index).getY()
						&& shots.get(count).getX() >= aliens.get(index).getX()
						&& shots.get(count).getX() <= aliens.get(index).getX() + 80)
				{
					shots.remove(count);
					aliens.get(index).setPos(0, -100);
				}
			}
		}
		
		
		for (int index = 0; index < shots.size(); index++)
		{
			shots.get(index).draw(graphToBack);
			shots.get(index).move("UP");
			
			if (shots.get(index).getY() <= -10)
			{
				shots.remove(index);
			}
		}
		
		
		if (keys[0] == true)
		{
			ship.move("LEFT");
		}
		if (keys[1] == true)
		{
			ship.move("RIGHT");
		}
		if (keys[2] == true)
		{
			ship.move("UP");
		}
		if (keys[3] == true)
		{
			ship.move("DOWN");
		}
		if (keys[5] == true)
		{
			ship.setPos(360, 260);
			for (int index = 0; index < 4; index++)
			{
				aliens.set(index, new Alien(-10 + (index * 140), 0, 2, "RIGHT"));
			}
		}
		
		
		
		if (ship.getX() <= -21)
		{
			ship.setPos(-21, ship.getY());
		}
		if (ship.getX() >= 725)
		{
			ship.setPos(725, ship.getY());
		}
		if (ship.getY() <= -10)
		{
			ship.setPos(ship.getX(), -10);
		}
		if (ship.getY() >= 480)
		{
			ship.setPos(ship.getX(), 480);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}
	
	
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_R)
		{
			keys[5] = true;
		}
		repaint();
	}
	
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_R)
		{
			keys[5] = false;
		}
		repaint();
	}
	
	public void keyTyped(KeyEvent e)
	{
		if (keys[4] == true)
		{
			shots.add(new Ammo(ship.getX() + 25, ship.getY(), 6));
		}
	}
	
	public void run()
	{
		try
		{
			while (true)
			{
				Thread.currentThread().sleep(7);
				repaint();
			}
		}catch (Exception e)
		{
		}
	}
}
