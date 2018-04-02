package Bored;


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


public class UltimatePong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Ball ball2;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private Paddle safeguardLeft;
	private Paddle safeguardRight;

	private Block topWall;
	private Block bottomWall;
	private Block leftWall;
	private Block rightWall;

	private int[] initialXSpeed;
	private int[] initialYSpeed;
	private int leftScore, rightScore;
	private boolean[] keys;
	private BufferedImage back;


	public UltimatePong()
	{
		// set up all variables related to the game

		ball = new BlinkyBall(400, 310, 10, 10, Color.BLACK, 0, 0);
		ball2 = new BlinkyBall(400, 310, 10, 10, Color.BLACK, 0, 0);
		ball.setVisible(false);
		ball2.setVisible(false);

		topWall = new Block(0, 0, 800, 5, Color.GRAY);
		bottomWall = new Block(0, 557, 800, 5, Color.GRAY);
		leftWall = new Block(0, 5, 5, 552, Color.YELLOW);
		rightWall = new Block(779, 5, 5, 552, Color.YELLOW);

		leftPaddle = new Paddle(leftWall.getX() + leftWall.getWidth() + 5, 275, 8, 80,
				Color.RED);
		rightPaddle = new Paddle(rightWall.getX() - leftPaddle.getWidth() - 5, 275, 8, 80,
				Color.BLUE);
		safeguardLeft = new Paddle(leftWall.getX() + leftWall.getWidth() + 5, 275, 12, 90,
				Color.RED);
		safeguardRight = new Paddle(rightWall.getX() - leftPaddle.getWidth() - 5, 275, 12, 90,
				Color.BLUE);

		leftScore = 0;
		rightScore = 0;
		keys = new boolean[6];

		initialXSpeed = new int[2];
		initialYSpeed = new int[2];


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

		back = (BufferedImage) (createImage(getWidth(), getHeight()));


		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		ball.moveAndDraw(graphToBack);
		ball2.moveAndDraw(graphToBack);

		graphToBack.setColor(Color.BLACK);
		graphToBack.drawString("Left Side Score: " + leftScore + "           "
				+ "Right Side Score: " + rightScore, 280, 600);
		graphToBack.drawString("Press \'spacebar\' to start the game and \'r\' to reset", 265,
				650);

		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);

		bottomWall.draw(graphToBack);
		topWall.draw(graphToBack);
		leftWall.draw(graphToBack);
		rightWall.draw(graphToBack);


		// see if ball hits left wall or right wall
		if (ball.didCollideRight(leftWall))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			ball.setVisible(false);
			ball.setPos(400, 310);
			rightScore++;
		}

		if (ball.didCollideLeft(rightWall))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			ball.setVisible(false);
			ball.setPos(400, 310);
			leftScore++;
		}

		if (ball2.didCollideRight(leftWall))
		{
			ball2.setXSpeed(0);
			ball2.setYSpeed(0);
			ball2.setVisible(false);
			ball2.setPos(400, 310);
			rightScore++;
		}

		if (ball2.didCollideLeft(rightWall))
		{
			ball2.setXSpeed(0);
			ball2.setYSpeed(0);
			ball2.setVisible(false);
			ball2.setPos(400, 310);
			leftScore++;
		}

		// prevent the paddles from exiting the screen

		if (leftPaddle.didCollideTop(bottomWall))
		{
			leftPaddle.setY(bottomWall.getY() - leftPaddle.getHeight());
			leftPaddle.draw(graphToBack);
		}

		if (leftPaddle.didCollideBottom(topWall))
		{
			leftPaddle.setY(topWall.getY() + topWall.getHeight());
			leftPaddle.draw(graphToBack);
		}

		if (rightPaddle.didCollideTop(bottomWall))
		{
			rightPaddle.setY(bottomWall.getY() - rightPaddle.getHeight());
			rightPaddle.draw(graphToBack);
		}

		if (rightPaddle.didCollideBottom(topWall))
		{
			rightPaddle.setY(topWall.getY() + topWall.getHeight());
			rightPaddle.draw(graphToBack);
		}

		// see if the ball hits the top or bottom wall
		if (ball.didCollideTop(bottomWall) || ball.didCollideBottom(topWall))
		{
			ball.setYSpeed(-ball.getYSpeed());
		}

		if (ball2.didCollideTop(bottomWall) || ball2.didCollideBottom(topWall))
		{
			ball2.setYSpeed(-ball2.getYSpeed());
		}

		// see if the ball hits the left paddle
		if (ball.didCollideRight(leftPaddle) || leftPaddle.didCollideLeft(ball))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed((int) (Math.ceil(Math.random() * 4 + 1)
					* Math.signum((double) ball.getYSpeed())));
		}

		if (ball.didCollideTop(leftPaddle) || ball.didCollideBottom(leftPaddle))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}

		// see if the ball hits the right paddle
		if (ball.didCollideLeft(rightPaddle) || rightPaddle.didCollideRight(ball))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed((int) (Math.ceil(Math.random() * 4 + 1)
					* Math.signum((double) ball.getYSpeed())));
		}

		if (ball.didCollideBottom(rightPaddle) || ball.didCollideTop(rightPaddle))
		{
			ball.setXSpeed(-ball.getXSpeed());
			ball.setYSpeed(-ball.getYSpeed());
		}

		if (ball2.didCollideRight(leftPaddle) || leftPaddle.didCollideLeft(ball2))
		{
			ball2.setXSpeed(-ball2.getXSpeed());
			ball2.setYSpeed((int) (Math.ceil(Math.random() * 4 + 1)
					* Math.signum((double) ball2.getYSpeed())));
		}

		if (ball2.didCollideTop(leftPaddle) || ball2.didCollideBottom(leftPaddle))
		{
			ball2.setXSpeed(-ball2.getXSpeed());
			ball2.setYSpeed(-ball2.getYSpeed());
		}

		// see if the ball hits the right paddle
		if (ball2.didCollideLeft(rightPaddle) || rightPaddle.didCollideRight(ball2))
		{
			ball2.setXSpeed(-ball2.getXSpeed());
			ball2.setYSpeed((int) (Math.ceil(Math.random() * 4 + 1)
					* Math.signum((double) ball2.getYSpeed())));
		}

		if (ball2.didCollideBottom(rightPaddle) || ball2.didCollideTop(rightPaddle))
		{
			ball2.setXSpeed(-ball2.getXSpeed());
			ball2.setYSpeed(-ball2.getYSpeed());
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
		if (keys[4] == true)
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			ball.setPos(400, 310);
			ball2.setXSpeed(0);
			ball2.setYSpeed(0);
			ball2.setPos(400, 310);

			leftScore = 0;
			rightScore = 0;
		}

		twoDGraph.drawImage(back, null, 0, 0);
	}

	public int randomXSpeed()
	{
		int randSpeed;
		do
		{
			randSpeed = (int) Math.ceil(Math.random() * 8) - 4;
		} while (randSpeed < 3 && randSpeed > -3);
		return randSpeed;
	}

	public int randomYSpeed()
	{
		int randSpeed;
		do
		{
			randSpeed = (int) Math.ceil(Math.random() * 6) - 3;
		} while (randSpeed == 0);
		return randSpeed;
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
		case 'R':
			keys[4] = true;
			break;
		case ' ':
			keys[5] = true;
			if (ball.getXSpeed() > 0 && ball2.getXSpeed() > 0 && ball.getVisible() == true
					&& ball2.getVisible() == true)
			{
				initialXSpeed[0] = ball.getXSpeed();
				initialXSpeed[1] = ball2.getXSpeed();

				initialYSpeed[0] = ball.getYSpeed();
				initialYSpeed[1] = ball2.getYSpeed();

				System.out.println(initialXSpeed.toString());

				ball.setXSpeed(0);
				ball.setYSpeed(0);
			}
			else if (ball.getXSpeed() == 0 && ball2.getXSpeed() == 0 && ball.getVisible() == false
					&& ball2.getVisible() == false && ball.getX() == 400 && ball.getY() == 310
					&& ball2.getX() == 400 && ball2.getY() == 310)
			{
				ball.setVisible(true);
				ball2.setVisible(true);
				ball.setXSpeed(Math.abs(randomXSpeed()) * -1);
				ball.setYSpeed(randomYSpeed());
				ball2.setXSpeed(Math.abs(randomXSpeed()));
				ball2.setYSpeed(randomYSpeed());
			}

			else if (ball.getXSpeed() == 0 && ball2.getXSpeed() == 0 && ball.getVisible() == true
					&& ball2.getVisible() == true)
			{
				ball.setXSpeed(initialXSpeed[0]);
				ball.setYSpeed(initialYSpeed[0]);
				ball2.setXSpeed(initialXSpeed[1]);
				ball2.setYSpeed(initialYSpeed[1]);

			}
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
		case 'R':
			keys[4] = false;
			break;
		case ' ':
			keys[5] = false;
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

