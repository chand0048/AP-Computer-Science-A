package javaProjectTareetria;


import java.awt.*;


public class Humanoid implements Locatable, Collidable
{
	private int xPos, yPos, width, height;

	private String direction;
	private Block head;
	private Block torso;
	private Block legs;
	private Color headColor, torsoColor, legsColor;


	public Humanoid()
	{
		this(400, 400, 20, 80, 5, 0, "RIGHT", new Color(255, 255, 180), Color.BLUE,
				new Color(153, 51, 0));
	}
	
	public Humanoid(int x, int y, int w, int h)
	{
		this(x, y, w, h, 5, 0, "RIGHT", new Color(255, 255, 180), Color.BLUE,
				new Color(153, 51, 0));
	}

	public Humanoid(int x, int y, int w, int h, int xS, int yS, String d, Color headCol,
			Color torsoCol, Color legsCol)
	{
		head = new Block(x, y, w, h, xS, yS, headCol);
		torso = new Block(x, y, w, h, xS, yS, torsoCol);
		legs = new Block(x, y, w, h, xS, yS, legsCol);
		setHeadColor(headCol);
		setTorsoColor(torsoCol);
		setLegsColor(legsCol);
		width = w;
		height = h;
		direction = d;
		setPos(x, y);

	}

	public void setX(int x)
	{
		xPos = x;
		setPerspective();
	}

	public void setY(int y)
	{
		yPos = y;
		setPerspective();
	}

	public void setPos(int x, int y)
	{
		setX(x);
		setY(y);
	}

	public void setWidth(int w)
	{
		width = w;
		setPerspective();
	}

	public void setHeight(int h)
	{
		height = h;
		setPerspective();
	}

	public void setXSpeed(int xS)
	{
		head.setXSpeed(xS);
		torso.setXSpeed(xS);
		legs.setXSpeed(xS);
	}

	public void setYSpeed(int yS)
	{
		head.setYSpeed(yS);
		torso.setYSpeed(yS);
		legs.setYSpeed(yS);
	}
	
	public void setDirection(String d)
	{
		direction = d;
		setPerspective();
	}
	
	public void setHeadColor(Color headCol)
	{
		headColor = headCol;
	}
	
	public void setTorsoColor(Color torsoCol)
	{
		torsoColor = torsoCol;
	}
	
	public void setLegsColor(Color legsCol)
	{
		legsColor = legsCol;
	}

	public int getX()
	{
		return xPos;
	}

	public int getY()
	{
		return yPos;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public String getDirection()
	{
		return direction;
	}
	
	public int getXSpeed()
	{
		return legs.getXSpeed();
	}
	
	public int getYSpeed()
	{
		return legs.getYSpeed();
	}
	
	public Color getHeadColor()
	{
		return headColor;
	}
	
	public Color getTorsoColor()
	{
		return torsoColor;
	}
	
	public Color getLegsColor()
	{
		return legsColor;
	}

	public void setPerspective()
	{
		if (getDirection().equals("LEFT"))
		{
			head.setX(getX());
			torso.setX(getX() + (getWidth() / 3));
			legs.setX(getX() + (getWidth() / 3));
			head.setY(getY());
			torso.setY(getY() + (getHeight() / 4));
			legs.setY(getY() + (3 * getHeight() / 4));
		}
		else if (getDirection().equals("RIGHT"))
		{
			head.setX(getX() + (getWidth() / 3));
			torso.setX(getX());
			legs.setX(getX() + (getWidth() / 3));
			head.setY(getY());
			torso.setY(getY() + (getHeight() / 4));
			legs.setY(getY() + (3 * getHeight() / 4));
		}
		head.setWidth(2 * getWidth() / 3);
		torso.setWidth(2 * getWidth() / 3);
		legs.setWidth(getWidth() / 3);
		head.setHeight(getHeight() / 4);
		torso.setHeight(getHeight() / 2);
		legs.setHeight(getHeight() / 4);
	}

	public void setPerspective(String dir)
	{
		setDirection(dir);
		setPerspective();
	}

	public boolean didCollide(Object obj, String side)
	{
		if (head.didCollide(obj, side) == true)
		{
			return head.didCollide(obj, side);
		}
		else if (torso.didCollide(obj, side) == true)
		{
			return torso.didCollide(obj, side);
		}
		else if (legs.didCollide(obj, side) == true)
		{
			return legs.didCollide(obj, side);
		}
		else
		{
			return false;
		}
	}

	public void draw(Graphics window)
	{
		head.draw(window);
		torso.draw(window);
		legs.draw(window);
	}

	public void draw(Graphics window, Color c)
	{
		head.draw(window, c);
		torso.draw(window, c);
		legs.draw(window, c);
	}

	public void moveAndDraw(Graphics window, String dir, Color background)
	{
		if (dir.equals("LEFT"))
		{
			draw(window, background);
			setPerspective(dir);
			setX(getX() - head.getXSpeed());
			draw(window);
		}
		else if (dir.equals("RIGHT"))
		{
			draw(window, background);
			setPerspective(dir);
			setX(getX() + head.getXSpeed());
			draw(window);
		}
		else if (dir.equals("UP"))
		{
			draw(window, background);
			setY(getY() - head.getYSpeed());
			draw(window);
		}
		else
		{
			System.out.println("Movement Direction DNE");
		}
	}
	
	public void fallAndDraw(Graphics window, Color background)
	{
		draw(window, background);
		setY(getY() - getYSpeed());
		draw(window);
	}

}
