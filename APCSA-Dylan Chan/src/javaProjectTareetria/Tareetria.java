package javaProjectTareetria;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import static java.lang.Character.*;

public class Tareetria extends Canvas implements KeyListener, Runnable
{
	Player Bob;
	private boolean[] keys;
	private BufferedImage back;
	
	
	public Tareetria()
	{
		setBackground(Color.LIGHT_GRAY);
		Bob = new Player();
		
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
		
		Bob.draw(graphToBack);
		
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
	public void keyPressed(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
}
