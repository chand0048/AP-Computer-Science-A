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
	private Block floor;
	private Player avatar;
	
	
	private List<Block> obstacles;
	private boolean[] keys;
	private BufferedImage back;
	
	
	public Tareetria()
	{
		setBackground(Color.LIGHT_GRAY);
		
		avatar = new Player();
		floor = new Block(0, 700, 1000, 20, 0, 0);
		
		obstacles = new ArrayList<Block>();
		
		obstacles.add(floor);
		obstacles.add(new Block(600, 660, 40, 40, 0, 0));
		obstacles.add(new Block(300, 560, 70, 40, 0, 0));
		obstacles.add(new Block(800, 500, 40, 200, 0, 0));
		
		
		keys = new boolean[4];
		
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
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
		
		avatar.draw(graphToBack);
		
		for (Block structure: obstacles)
		{
			structure.draw(graphToBack);
		}
		
		// GRAVITY
		
		if (avatar.getFalling() == true)
		{
			if (avatar.getYSpeed() < -15)
			{
				avatar.setYSpeed(-15);
			}
			else
			{
				avatar.setYSpeed(avatar.getYSpeed() - 1);
			}
			avatar.fallAndDraw(graphToBack, Color.LIGHT_GRAY);
		}
		avatar.setFalling(true);
		
		// COLLISION DETECTION
		for (Block structure: obstacles)
		{
			if (avatar.didCollide(structure, "TOP") == true)
			{
				avatar.draw(graphToBack, Color.LIGHT_GRAY);
				avatar.setY(structure.getY() + structure.getHeight());
				avatar.setYSpeed(0);
				avatar.draw(graphToBack);
			}
			if (avatar.didCollide(structure, "BOTTOM") == true
					&& !avatar.didCollide(structure, "LEFT")
					&& !avatar.didCollide(structure, "RIGHT"))
			{
				avatar.draw(graphToBack, Color.LIGHT_GRAY);
				avatar.setY(structure.getY() - avatar.getHeight());
				avatar.setYSpeed(0);
				avatar.setFalling(false);
				avatar.draw(graphToBack);
			}
			if (avatar.didCollide(structure, "LEFT") == true)
			{
				avatar.draw(graphToBack, Color.LIGHT_GRAY);
				avatar.setXSpeed(0);
				avatar.setX(structure.getX() + structure.getWidth());
				avatar.draw(graphToBack);
			}
			if (avatar.didCollide(structure, "RIGHT") == true)
			{
				avatar.draw(graphToBack, Color.LIGHT_GRAY);
				avatar.setXSpeed(0);
				
				avatar.setX(structure.getX() - avatar.getWidth());
				avatar.draw(graphToBack);
			}
		}
		
		// MOVEMENT CONTROLS
		// Jump
		if (keys[0])
		{
			for (Block structure: obstacles)
			{
				if (avatar.didCollide(structure, "BOTTOM") == true
						&& avatar.getFalling() == false)
				{
					avatar.setYSpeed(avatar.getJumpHeight());
					avatar.moveAndDraw(graphToBack, "UP", Color.LIGHT_GRAY);
					avatar.setFalling(true);
				}
			}
			
		}
		// Move Left
		if (keys[1])
		{
			avatar.setXSpeed(5);
			avatar.moveAndDraw(graphToBack, "LEFT", Color.LIGHT_GRAY);
		}
		// Move Right
		if (keys[2])
		{
			avatar.setXSpeed(5);
			avatar.moveAndDraw(graphToBack, "RIGHT", Color.LIGHT_GRAY);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}
	
	@Override
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
	
	@Override
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
		switch (e.getButton())
		{
		case 1:
			obstacles.add(new Block(e.getX() - 20, e.getY() - 20, 40, 40, 0, 0));
			break;
		case 3:
			System.out.println("RUN");
			for (Block structure: obstacles)
			{
				if (structure.getX() <= e.getX()
						&& structure.getX() + structure.getWidth() >= e.getX()
						&& structure.getY() <= e.getY()
						&& structure.getY() + structure.getHeight() >= e.getY())
				{
					obstacles.remove(structure);
				}
			}
			break;
		}
		
		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0)
	{
	}
	
	@Override
	public void mousePressed(MouseEvent arg0)
	{
		
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
}
