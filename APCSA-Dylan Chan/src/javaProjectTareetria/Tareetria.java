package javaProjectTareetria;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import static java.lang.Character.*;


public class Tareetria extends Canvas implements KeyListener, Runnable
{
	Block floor;
	Player avatar;
	private boolean[] keys;
	private BufferedImage back;


	public Tareetria()
	{
		setBackground(Color.LIGHT_GRAY);
		floor = new Block(0, 700, 1000, 20, 0, 0);
		avatar = new Player();

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

		if (!avatar.didCollide(floor).equals("BOTTOM"))
		{
			avatar.setYSpeed(avatar.getYSpeed() - 1);
			avatar.fallAndDraw(graphToBack, Color.LIGHT_GRAY);
		}
		else 
		{
			avatar.setYSpeed(0);
		}


		if (keys[0])
		{
			if (avatar.didCollide(floor).equals("BOTTOM"))
			{
				avatar.setYSpeed(10);
				avatar.moveAndDraw(graphToBack, "UP", Color.LIGHT_GRAY);
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
				Thread.currentThread().sleep(7);
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
