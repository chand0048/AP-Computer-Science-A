package unit15;


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


public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private Block topWall;
	private Block bottomWall;
	private Block leftWall;
	private Block rightWall;
	private boolean[] keys;
	private BufferedImage back;


	public Pong()
	{
		// set up all variables related to the game
		ball = new Ball(200, 200, 10, 10, Color.BLACK, 3, 2);
		leftPaddle = new Paddle(20, 275, 5, 100, Color.RED);
		rightPaddle = new Paddle(760, 275, 5, 100, Color.BLUE);
		topWall = new Block(0,0,800, 5, Color.GRAY);
		bottomWall = new Block(0,557, 800, 5, Color.GRAY);

		keys = new boolean[4];


		setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this); // starts the key thread to log key strokes
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

		// take a snap shop of the current screen and save it as an image
		// that is the exact same width and height as the current screen
		//if (back == null)
		{
			back = (BufferedImage) (createImage(getWidth(), getHeight()));
		}

		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		bottomWall.draw(graphToBack);
		topWall.draw(graphToBack);


		// see if ball hits left wall or right wall
		if (!(ball.getX() >= 0 && ball.getX() <= 772))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			
		}

		// see if the ball hits the top or bottom wall
		if (ball.didCollideTop(bottomWall) || ball.didCollideBottom(topWall))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		// see if the ball hits the left paddle
		if (ball.didCollideRight(leftPaddle))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}

		// see if the ball hits the right paddle
		if (ball.didCollideLeft(rightPaddle))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}

		// see if the paddles need to be moved
		if (keys[0] == true)
		{
			leftPaddle.moveUpAndDraw(window);
		}
		if (keys[1] == true)
		{
			leftPaddle.moveDownAndDraw(window);
		}
		if (keys[2] == true)
		{
			rightPaddle.moveUpAndDraw(window);
		}
		if (keys[3] == true)
		{
			rightPaddle.moveDownAndDraw(window);
		}

		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = true;
			break;
		case 'Z':
			keys[1] = true;
			break;
		case 'I':
			keys[2] = true;
			break;
		case 'M':
			keys[3] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = false;
			break;
		case 'Z':
			keys[1] = false;
			break;
		case 'I':
			keys[2] = false;
			break;
		case 'M':
			keys[3] = false;
			break;
		}
	}

	public void keyTyped(KeyEvent e)
	{
	}

	public void run()
	{
		try
		{
			while (true)
			{
				Thread.currentThread().sleep(8);
				repaint();
			}
		} catch (Exception e)
		{
		}
	}
}
