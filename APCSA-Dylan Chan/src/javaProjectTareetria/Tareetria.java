package javaProjectTareetria;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


import static java.lang.Character.*;


public class Tareetria extends Canvas implements KeyListener, Runnable
{
	private Block floor;
	private Player avatar;
	
	
	List<Block> obstacles;
	private boolean[] keys;
	private BufferedImage back;


	public Tareetria()
	{
		setBackground(Color.LIGHT_GRAY);
		
		avatar = new Player();
		floor = new Block(0, 700, 1000, 20, 0, 0);
		
		obstacles = new ArrayList<Block>();
		
		obstacles.add(floor);
		

		
		keys = new boolean[4];

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

		avatar.draw(graphToBack);
		floor.draw(graphToBack);
		
		//GRAVITY
		for (Block structure: obstacles)
		{
			if (avatar.didCollide(structure).equals("BOTTOM"))
			{
				avatar.setY(structure.getY() - avatar.getHeight());
				avatar.setYSpeed(0);
				avatar.draw(graphToBack);
				System.out.println("HIT");
			}
			else 
			{
				avatar.setYSpeed(avatar.getYSpeed() - 1);
				avatar.fallAndDraw(graphToBack, Color.LIGHT_GRAY);
			}
		}

		if (keys[0])
		{
			for (Block structure: obstacles)
			{
				if (avatar.didCollide(structure).equals("BOTTOM"))
				{
					avatar.setYSpeed(avatar.getJumpHeight());
					avatar.moveAndDraw(graphToBack, "UP", Color.LIGHT_GRAY);
				}
			}
			
		}
		if (keys[1])
		{
			avatar.moveAndDraw(graphToBack, "LEFT", Color.LIGHT_GRAY);
		}
		if (keys[2])
		{
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
		} catch (Exception e)
		{
			System.out.println(e);
		}

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode()) {
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
		switch (e.getKeyCode()) {
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

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub

	}

}
