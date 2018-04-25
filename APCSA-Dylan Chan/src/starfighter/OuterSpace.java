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
	private int alienSpeedDown;

	private ArrayList<Alien> aliens;
	private ArrayList<Ammo> shots;

	private Alien closestAlien;

	private int score;
	private int highScore;

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[6];

		aliens = new ArrayList<Alien>();

		closestAlien = new Alien(-50, -50, 0, "UP");

		alienSpeedDown = 15;

		for (int index = 0; index < 5; index++)
		{
			aliens.add(new Alien(index * 120, 40, 2, "RIGHT"));
		}

		shots = new ArrayList<Ammo>();

		ship = new Ship(360, 260, 3);

		score = 0;
		highScore = 0;

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
		graphToBack.drawString("SCORE: " + score, 450, 20);
		graphToBack.drawString("HIGH SCORE: " + highScore, 250, 20);


		ship.draw(graphToBack);


		for (int index = 0; index < aliens.size(); index++)
		{
			aliens.get(index).draw(graphToBack);
			aliens.get(index).move(aliens.get(index).getDirection());

			if (aliens.get(index).getY() > closestAlien.getY())
			{
				closestAlien = aliens.get(index);
			}

			if (aliens.get(index).getX() <= 0 + (index * 120))
			{
				if (aliens.get(index).getDirection().equals("LEFT"))
				{
					aliens.get(index).setDirection("DOWN");
					aliens.get(index).setSpeed(alienSpeedDown);
					aliens.get(index).move(aliens.get(index).getDirection());
					aliens.get(index).setSpeed(2);

					aliens.get(index).setDirection("RIGHT");
				}
				else if (aliens.get(index).getDirection().equals("RIGHT"))
				{
					aliens.get(index).setDirection("DOWN");
					aliens.get(index).setSpeed(alienSpeedDown);
					aliens.get(index).move(aliens.get(index).getDirection());
					aliens.get(index).setSpeed(2);

					aliens.get(index).setDirection("LEFT");
				}
			}
			else if (aliens.get(index).getX() >= 260 + (index * 120))
			{
				if (aliens.get(index).getDirection().equals("LEFT"))
				{
					aliens.get(index).setDirection("DOWN");
					aliens.get(index).setSpeed(alienSpeedDown);
					aliens.get(index).move(aliens.get(index).getDirection());
					aliens.get(index).setSpeed(2);

					aliens.get(index).setDirection("RIGHT");
				}
				else if (aliens.get(index).getDirection().equals("RIGHT"))
				{
					aliens.get(index).setDirection("DOWN");
					aliens.get(index).setSpeed(alienSpeedDown);
					aliens.get(index).move(aliens.get(index).getDirection());
					aliens.get(index).setSpeed(2);

					aliens.get(index).setDirection("LEFT");
				}
			}

			

			if (ship.getY() <= aliens.get(index).getY() + 50
					&& ship.getY() + 70 >= aliens.get(index).getY()
					&& ship.getX() >= aliens.get(index).getX()
					&& ship.getX() + 40 <= aliens.get(index).getX() + 50)
			{
				for (Alien being : aliens)
				{
					being.setSpeed(0);
				}
				ship.setSpeed(0);
				shots.clear();
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("YOU DIED!", 370, 400);
				graphToBack.drawString("Press R to reset", 355, 415);
			}

			if (aliens.get(index).getY() + 50 >= 560)
			{
				for (Alien being : aliens)
				{
					being.setSpeed(0);
				}
				ship.setSpeed(0);
				shots.clear();
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("YOU LOST!", 370, 400);
				graphToBack.drawString("Press R to reset", 355, 415);
			}


			for (int count = 0; count < shots.size(); count++)
			{
				if (shots.get(count).getY() <= aliens.get(index).getY() + 50
						&& shots.get(count).getY() >= aliens.get(index).getY()
						&& shots.get(count).getX() >= aliens.get(index).getX()
						&& shots.get(count).getX() <= aliens.get(index).getX() + 50)
				{
					shots.remove(count);
					aliens.get(index).setPos(aliens.get(index).getX(), -50);
					score++;
					if (score % 5 == 0)
					{
						alienSpeedDown += 2;
					}
				}
			}
		}


		for (int index = 0; index < shots.size(); index++)
		{
			shots.get(index).draw(graphToBack);
			shots.get(index).move("UP");

			if (shots.get(index).getY() <= 0)
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
			ship.setSpeed(3);
			for (int index = 0; index < 5; index++)
			{
				aliens.set(index, new Alien(index * 120, 40, 2, "RIGHT"));
			}
			if (score > highScore)
			{
				highScore = score;
			}
			score = 0;
			alienSpeedDown = 15;
		}


		if (ship.getX() <= 0)
		{
			ship.setPos(0, ship.getY());
		}
		if (ship.getX() >= 735)
		{
			ship.setPos(735, ship.getY());
		}
		if (ship.getY() <= 0)
		{
			ship.setPos(ship.getX(), 0);
		}
		if (ship.getY() >= 490)
		{
			ship.setPos(ship.getX(), 490);
		}


		if (closestAlien.getDirection().equals("LEFT")
				&& (ship.getY() - closestAlien.getY() + 50)
						/ (ship.getSpeed() + 2) > (closestAlien.getX() - ship.getX() + 16)
								/ (closestAlien.getSpeed()))
		{
			ship.move("LEFT");
		}
		else if (closestAlien.getDirection().equals("LEFT")
				&& (ship.getY() - closestAlien.getY() + 50)
						/ (ship.getSpeed() + 2) < (closestAlien.getX() - ship.getX() + 16)
								/ (closestAlien.getSpeed()))
		{
			ship.move("RIGHT");
		}
		else if (closestAlien.getDirection().equals("LEFT")
				&& (ship.getY() - closestAlien.getY() + 50)
						/ (ship.getSpeed() + 2) == (closestAlien.getX() - ship.getX() + 16)
								/ (closestAlien.getSpeed()))
		{
			shots.add(new Ammo(ship.getX() + 16, ship.getY(), ship.getSpeed() + 2));
		}
		else if (closestAlien.getDirection().equals("RIGHT")
				&& (ship.getY() - closestAlien.getY() + 50)
						/ (ship.getSpeed() + 2) > (ship.getX() + 16-closestAlien.getX())
								/ (closestAlien.getSpeed()))
		{
			ship.move("RIGHT");
		}
		else if (closestAlien.getDirection().equals("RIGHT")
				&& (ship.getY() - closestAlien.getY() + 50)
						/ (ship.getSpeed() + 2) < (ship.getX() + 16-closestAlien.getX())
								/ (closestAlien.getSpeed()))
		{
			ship.move("LEFT");
		}
		else if (closestAlien.getDirection().equals("RIGHT")
				&& (ship.getY() - closestAlien.getY() + 50)
						/ (ship.getSpeed() + 2) == (ship.getX() + 16-closestAlien.getX())
								/ (closestAlien.getSpeed()))
		{
			shots.add(new Ammo(ship.getX() + 16, ship.getY(), ship.getSpeed() + 2));
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
		if (keys[4] == true && shots.size() <= 2)
		{
			shots.add(new Ammo(ship.getX() + 16, ship.getY(), ship.getSpeed() + 2));
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
		} catch (Exception e)
		{
		}
	}
}
