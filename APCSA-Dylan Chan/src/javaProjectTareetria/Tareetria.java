package javaProjectTareetria;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.*;


public class Tareetria extends Canvas
		implements KeyListener, MouseListener, MouseMotionListener, Runnable
{
	private List<Block> obstacles;
	private boolean existingBlock;
	private Block floor;
	private Player avatar;
	private boolean scrollX;
	
	private Mouse mouseOutline;
	private boolean[] keys;
	private boolean[] mouse;
	private int mouseX;
	private int mouseY;
	
	private BufferedImage back;
	
	
	public Tareetria()
	{
		setBackground(Color.LIGHT_GRAY);
		
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		new Thread(this).start();
		
		setVisible(true);
		
		obstacles = new ArrayList<Block>();
		existingBlock = false;
		floor = new Block(-2280, 720, 5660, 20, 0, 0);
		obstacles.add(floor);
		obstacles.add(new Block(600, 680, 40, 40, 0, 0));
		obstacles.add(new Block(600, 640, 40, 40, 0, 0));
		// obstacles.add(new Block(600, 590, 40, 40, 0, 0));
		
		
		avatar = new Player(490, 630, 20, 80, 0, 0, "RIGHT", new Color(255, 255, 180),
				Color.BLUE, new Color(153, 51, 0), 100, 15, false, "NONE");
		
		scrollX = false;
		
		keys = new boolean[4];
		mouse = new boolean[2];
		mouseX = 0;
		mouseY = 0;
		
		mouseOutline = new Mouse(mouseX - 20, mouseY - 20, Color.GREEN);
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
		
		
		avatar.setFalling(true);
		
		// COLLISION DETECTION
		for (Block structure: obstacles)
		{
			if (avatar.didCollide(structure, "LEFT")
					&& !avatar.didCollide(structure, "BOTTOM"))
			{
				avatar.draw(graphToBack, getBackground());
				
				if (scrollX == true)
				{
					avatar.setXSpeed(structure.getXSpeed());
				}
				else if (scrollX == false)
				{
					avatar.setXSpeed(0);
				}
				
				avatar.setX(structure.getX() + structure.getWidth());
				avatar.draw(graphToBack);
			}
			else if (avatar.didCollide(structure, "RIGHT")
					&& !avatar.didCollide(structure, "BOTTOM"))
			{
				avatar.draw(graphToBack, getBackground());
				
				if (scrollX == true)
				{
					avatar.setXSpeed(structure.getXSpeed());
				}
				else if (scrollX == false)
				{
					avatar.setXSpeed(0);
				}
				
				avatar.setX(structure.getX() - avatar.getWidth());
				avatar.draw(graphToBack);
			}
			if (avatar.didCollide(structure, "BOTTOM")
					&& !avatar.didCollide(structure, "LEFT")
					&& !avatar.didCollide(structure, "RIGHT"))
			{
				avatar.draw(graphToBack, getBackground());
				avatar.setY(structure.getY() - avatar.getHeight());
				avatar.setYSpeed(0);
				avatar.setFalling(false);
				avatar.draw(graphToBack);
			}
			else if (avatar.didCollide(structure, "TOP"))
			{
				avatar.draw(graphToBack, getBackground());
				avatar.setY(structure.getY() + structure.getHeight());
				avatar.setYSpeed(0);
				avatar.setFalling(true);
				avatar.draw(graphToBack);
			}
		}
		
		// GRAVITY
		
		if (avatar.getFalling() == true)
		{
			if (scrollX == false && avatar.getYSpeed() < -15)
			{
				avatar.setYSpeed(-15);
			}
			else if (scrollX == true && avatar.getYSpeed() < -20)
			{
				avatar.setYSpeed(-20);
			}
			else
			{
				avatar.setYSpeed(avatar.getYSpeed() - 1);
			}
		}
		
		
		// MOVEMENT CONTROLS
		// Jump-"W"
		if (keys[0])
		{
			for (Block structure: obstacles)
			{
				if (avatar.didCollide(structure, "BOTTOM") == true
						&& avatar.getFalling() == false)
				{
					avatar.setYSpeed(avatar.getYSpeed() + avatar.getJumpHeight());
					avatar.setFalling(true);
				}
			}
			
		}
		
		/*
		 * Realistic Physics - Cannot change direction in mid-air
		 * // Move Left-"A"
		 * if (keys[1] && avatar.getFalling() == false)
		 * {
		 * avatar.setXSpeed(-5);
		 * }
		 * // Move Right-"D"
		 * else if (keys[2] && avatar.getFalling() == false)
		 * {
		 * avatar.setXSpeed(5);
		 * }
		 * else if (avatar.getFalling() == false)
		 * {
		 * avatar.setXSpeed(0);
		 * }
		 */
		
		/*
		 * Fun Physics - Can change direction in mid-air
		 */
		
		// Move Left-"A"
		if (keys[1])
		{
			avatar.draw(graphToBack, getBackground());
			avatar.setDirection("LEFT");
			if (avatar.getMoving().equals("NONE"))
			{
				avatar.setXSpeed(avatar.getXSpeed() - 5);
				avatar.setMoving("LEFT");
			}
			else if (avatar.getMoving().equals("RIGHT"))
			{
				avatar.setXSpeed(avatar.getXSpeed() - 10);
				avatar.setMoving("LEFT");
			}
		}
		// Move Right-"D"
		else if (keys[2])
		{
			avatar.draw(graphToBack, getBackground());
			avatar.setDirection("RIGHT");
			if (avatar.getMoving().equals("NONE"))
			{
				avatar.setXSpeed(avatar.getXSpeed() + 5);
				avatar.setMoving("RIGHT");
			}
			else if (avatar.getMoving().equals("LEFT"))
			{
				avatar.setXSpeed(avatar.getXSpeed() + 10);
				avatar.setMoving("RIGHT");
			}
		}
		else
		{
			if (scrollX == true)
			{
				avatar.setXSpeed(floor.getXSpeed());
			}
			else if (scrollX == false)
			{
				avatar.setXSpeed(0);
			}
			
			avatar.setMoving("NONE");
		}
		
		
		// MOUSE
		// Left Mouse Button
		if (mouse[0] && scrollX == false)
		{
			if (existingBlock == false && !(avatar.getX() > mouseX
					&& avatar.getX() + avatar.getWidth() < mouseX + 40
					&& avatar.getY() <= mouseY
					&& avatar.getY() + avatar.getHeight() >= mouseY + 40))
			{
				obstacles.add(new Block(mouseX, mouseY, 40, 40, floor.getXSpeed(), 0));
			}
			
			mouse[0] = false;
		}
		// Right Mouse Button
		if (mouse[1] && scrollX == false)
		{
			for (Block structure: obstacles)
			{
				if (structure.getX() == mouseX && structure.getY() == mouseY)
				
				{
					structure.setColor(getBackground());
					structure.draw(graphToBack);
					obstacles.remove(structure);
					break;
				}
			}
			mouse[1] = false;
		}
		
		// RE-CENTER SCREEN & ARENA BOUNDARIES
		// One Re-Center moves the FOV by 320 pixels
		if (avatar.getX() >= 470 && avatar.getX() <= 520)
		{
			scrollX = false;
			
			if (avatar.getMoving().equals("LEFT"))
			{
				avatar.setXSpeed(-5);
			}
			else if (avatar.getMoving().equals("RIGHT"))
			{
				avatar.setXSpeed(5);
			}
			else
			{
				avatar.setXSpeed(0);
			}
			
			for (Block structure: obstacles)
			{
				structure.setXSpeed(0);
			}
		}
		// Boundary Limits
		else if (avatar.getX() + avatar.getWidth() + 400 > floor.getX()
				+ floor.getWidth())
		{
			scrollX = false;
			if (avatar.getX() + avatar.getWidth() >= 980
					&& avatar.getDirection().equals("RIGHT"))
			{
				avatar.draw(graphToBack, getBackground());
				avatar.setXSpeed(0);
				avatar.setX(980 - avatar.getWidth());
				avatar.draw(graphToBack);
			}
		}
		else if (avatar.getX() - 400 < floor.getX())
		{
			scrollX = false;
			if (avatar.getX() <= 10 && avatar.getDirection().equals("LEFT"))
			{
				avatar.draw(graphToBack, getBackground());
				avatar.setXSpeed(0);
				avatar.setX(5);
				avatar.draw(graphToBack);
			}
		}
		else if (avatar.getY() < 0)
		{
			avatar.draw(graphToBack, getBackground());
			avatar.setYSpeed(0);
			avatar.setY(0);
			avatar.draw(graphToBack);
		}
		
		else if (avatar.getX() > 800)
		{
			scrollX = true;
		}
		else if (avatar.getX() < 200)
		{
			scrollX = true;
		}
		
		if (scrollX)
		{
			if (avatar.getX() > 490 && Math.abs(avatar.getXSpeed()) <= 5)
			{
				avatar.setXSpeed(avatar.getXSpeed() - 1);
				for (Block structure: obstacles)
				{
					structure.setXSpeed(structure.getXSpeed() - 1);
				}
			}
			else if (avatar.getX() < 490 && Math.abs(avatar.getXSpeed()) <= 5)
			{
				avatar.setXSpeed(avatar.getXSpeed() + 1);
				for (Block structure: obstacles)
				{
					structure.setXSpeed(structure.getXSpeed() + 1);
				}
			}
		}
		
		// MOVE & DRAW
		
		// Mouse Outline
		existingBlock = false;
		for (Block structure: obstacles)
		{
			if (structure.getX() == mouseX && structure.getY() == mouseY)
			{
				existingBlock = true;
			}
		}
		
		if (existingBlock == true || avatar.getX() > mouseX && avatar.getX() + avatar.getWidth() < mouseX + 40
				&& avatar.getY() <= mouseY
				&& avatar.getY() + avatar.getHeight() >= mouseY + 40)
		{
			mouseOutline.setOutlineColor(Color.RED);
		}
		else
		{
			mouseOutline.setOutlineColor(Color.GREEN);
		}
		
		if (scrollX == false)
		{
			mouseOutline.moveAndDraw(graphToBack, mouseX, mouseY, getBackground());
		}
		else
		{
			mouseOutline.draw(graphToBack, getBackground());
		}
		
		// Draw
		avatar.moveAndDraw(graphToBack, avatar.getXSpeed(), avatar.getYSpeed(),
				getBackground());
		
		for (Block structure: obstacles)
		{
			if (structure.equals(floor)
					|| (structure.getX() >= -50 && structure.getX() <= 1050))
			{
				structure.moveAndDraw(graphToBack, structure.getXSpeed(),
						structure.getYSpeed(), getBackground());
			}
			else
			{
				structure.draw(graphToBack, getBackground());
				structure.move(structure.getXSpeed(), structure.getYSpeed());
			}
		}
		
		
		twoDGraph.drawImage(back, null, 0, 0);
	}
	
	public void run()
	{
		try
		{
			while (true)
			{
				Thread.currentThread().sleep(15);
				repaint();
			}
		}catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_W:
			keys[0] = true;
			break;
		case KeyEvent.VK_A:
			keys[1] = true;
			break;
		case KeyEvent.VK_D:
			keys[2] = true;
			break;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_W:
			keys[0] = false;
			break;
		case KeyEvent.VK_A:
			keys[1] = false;
			break;
		case KeyEvent.VK_D:
			keys[2] = false;
			break;
		}
	}
	
	public void keyTyped(KeyEvent arg0)
	{
		
	}
	
	public void mouseClicked(MouseEvent e)
	{
		
	}
	
	public void mouseEntered(MouseEvent e)
	{
		mouseOutline.setOutlineColor(Color.GREEN);
	}
	
	public void mouseExited(MouseEvent arg0)
	{
		mouseOutline.setOutlineColor(getBackground());
	}
	
	public void mousePressed(MouseEvent e)
	{
		System.out.println(e.getX() + ", " + e.getY());
		
		switch (e.getButton())
		{
		case 1:
			mouse[0] = true;
			break;
		case 3:
			mouse[1] = true;
			break;
		}
	}
	
	public void mouseReleased(MouseEvent arg0)
	{
		
	}
	
	public void mouseDragged(MouseEvent arg0)
	{
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX() - ((e.getX() - floor.getX()) % 40);
		mouseY = e.getY() - (e.getY() % 40);
	}
	
}
