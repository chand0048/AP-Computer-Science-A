package javaProjectTareetria;


import java.awt.*;


public class Humanoid implements Locatable, Collidable
{
	private int xPos, yPos, width, height;

	private String direction;
	private Block head;
	private Block torso;
	private Block legs;


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

	public String didCollide(Object obj)
	{
		if (!legs.didCollide(obj).equals("NONE"))
		{
			System.out.println("LC");
			return legs.didCollide(obj);
		}
		else if (!torso.didCollide(obj).equals("NONE"))
		{
			System.out.println("TC");
			return torso.didCollide(obj);
		}
		else if (!head.didCollide(obj).equals("NONE"))
		{
			System.out.println("HC");
			return head.didCollide(obj);
		}
		else
		{
			return "NONE";
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
