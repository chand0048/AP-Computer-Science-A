package unit15;

import java.awt.Color;
import java.awt.Component;
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


public class Breakout extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle rightPaddle;

	private Block topWall;
	private Block bottomWall;
	private Block leftWall;
	private Block rightWall;
	private ArrayList<Block> brickArray;


	private int score;
	private boolean[] keys;
	private BufferedImage back;


	public Breakout()
	{
		System.out.println("Dylan Chan, Period 4, 4/4/18, Computer Num: 6");
		// set up all variables related to the game

		ball = new Ball(400, 310, 10, 10, Color.BLACK, 0, 0);

		topWall = new Block(0, 0, 800, 5, Color.GRAY);
		bottomWall = new Block(0, 557, 800, 5, Color.GRAY);
		leftWall = new Block(0, 5, 5, 552, Color.GRAY);
		rightWall = new Block(779, 5, 5, 552, Color.YELLOW);

		brickArray = new ArrayList<Block>();

		int index = 0;

		for (int column = 0; column < 4; column++)
		{
			for (int row = 0; row < 5; row++)
			{
				brickArray.add(new Block(leftWall.getX() + 17 + (20 * column),
						topWall.getY() + 17 + (107 * row), 6, 90, Color.BLACK));
				index++;
			}
		}

		rightPaddle = new Paddle(rightWall.getX() - 20, 275, 8, 80, Color.BLUE);

		score = 0;
		keys = new boolean[6];


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
		// if (back == null)
		{
			back = (BufferedImage) (createImage(getWidth(), getHeight()));
		}

		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		ball.moveAndDraw(graphToBack);
		graphToBack.setColor(Color.BLACK);
		graphToBack.drawString("Score: " + score, 280, 50);
		graphToBack.drawString("Press \'r\' to reset and \'spacebar\' to start the game", 280,
				550);

		rightPaddle.draw(graphToBack);
		bottomWall.draw(graphToBack);
		topWall.draw(graphToBack);
		leftWall.draw(graphToBack);
		rightWall.draw(graphToBack);

		for (Block brick : brickArray)
		{
			brick.draw(graphToBack);
		}


		// see if ball hits left wall or right wall
		if (ball.didCollideLeft(leftWall))
		{
			ball.setXSpeed(-ball.getXSpeed());
		}

		if (ball.didCollideRight(rightWall))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			ball.setPos(400, 310);
		}

		// see if the ball hits the top or bottom wall
		if (ball.didCollideTop(bottomWall) || ball.didCollideBottom(topWall))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		// see if ball hits a brick

		for (Block brick : brickArray)
		{
			if (ball.didCollideBottom(brick) || ball.didCollideTop(brick))
			{
				ball.setYSpeed(-ball.getYSpeed());
				brickArray.set(brickArray.indexOf(brick), new Block(0, 0, 0, 0, Color.GRAY));
				score++;
			}
			if (ball.didCollideLeft(brick) || ball.didCollideRight(brick))
			{
				ball.setXSpeed(-ball.getXSpeed());
				brickArray.set(brickArray.indexOf(brick), new Block(0, 0, 0, 0, Color.GRAY));
				score++;
			}
		}
		
		// see if the game is won
		
		if (score == 20)
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			ball.setPos(400, 310);

			brickArray.clear();

		}

		// see if the ball hits the right paddle
		if (ball.didCollideRight(rightPaddle))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed((int) (Math.ceil(Math.random() * 2 + 1)
					* Math.signum((double) ball.getYSpeed())));
		}

		if (ball.didCollideBottom(rightPaddle) || ball.didCollideTop(rightPaddle))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}

		// prevents paddles from exiting the screen

		if (rightPaddle.getX() >= bottomWall.getX()
				&& rightPaddle.getX() <= bottomWall.getX() + bottomWall.getWidth()
						- rightPaddle.getWidth()
				&& rightPaddle.getY() <= bottomWall.getY() + bottomWall.getHeight()
						- rightPaddle.getHeight()
				&& rightPaddle.getY() >= bottomWall.getY() - rightPaddle.getHeight())
		{
			rightPaddle.setY(bottomWall.getY() - rightPaddle.getHeight());
			rightPaddle.draw(graphToBack);
		}

		if (rightPaddle.getX() >= topWall.getX()
				&& rightPaddle.getX() <= topWall.getX() + topWall.getWidth()
						- rightPaddle.getWidth()
				&& rightPaddle.getY() >= topWall.getY()
				&& rightPaddle.getY() <= topWall.getY() + topWall.getHeight())
		{
			rightPaddle.setY(topWall.getY() + topWall.getHeight());
			rightPaddle.draw(graphToBack);
		}
		
		// see if the paddles need to be moved

		if (keys[0] == true)
		{
			rightPaddle.moveUpAndDraw(window);
		}
		if (keys[1] == true)
		{
			rightPaddle.moveDownAndDraw(window);
		}
		if (keys[2] == true)
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			ball.setPos(400, 310);

			brickArray.clear();

			score = 0;
			
			int index = 0;

			for (int column = 0; column < 4; column++)
			{
				for (int row = 0; row < 5; row++)
				{
					brickArray.add(new Block(leftWall.getX() + 17 + (20 * column),
							topWall.getY() + 17 + (107 * row), 6, 90, Color.BLACK));
					index++;
				}
			}
		}
		if (keys[3] == true)
		{
			if (ball.getXSpeed() == 0 && ball.getYSpeed() == 0 && score == 0)
			{
				score = 0;
				ball.setXSpeed(3);
				ball.setYSpeed(2);
			}
		}

		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch (toUpperCase(e.getKeyChar())) {
		case 'I':
			keys[0] = true;
			break;
		case 'M':
			keys[1] = true;
			break;
		case 'R':
			keys[2] = true;
			break;
		case ' ':
			keys[3] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch (toUpperCase(e.getKeyChar())) {
		case 'I':
			keys[0] = false;
			break;
		case 'M':
			keys[1] = false;
			break;
		case 'R':
			keys[2] = false;
			break;
		case ' ':
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
				Thread.currentThread().sleep(7);
				repaint();
			}
		} catch (Exception e)
		{
		}
	}
}
