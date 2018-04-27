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
		this(0, 0, 10, 40, 2, 2, "RIGHT", new Color(255, 255, 180), Color.BLUE,
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
	
	public int getX()
	{
		return xPos;
	}
	
	@Override
	public int getY()
	{
		return yPos;
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
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setDirection(String d)
	{
		direction = d;
		setPerspective();
	}
	
	public String getDirection()
	{
		return direction;
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
	
	public String didCollide(Object obj)
	{
		if (!head.didCollide(obj).equals("NONE"))
		{
			return head.didCollide(obj);
		}
		else if (!torso.didCollide(obj).equals("NONE"))
		{
			return torso.didCollide(obj);
		}
		else if (!legs.didCollide(obj).equals("NONE"))
		{
			return torso.didCollide(obj);
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
	
	public void moveAndDraw(Graphics window, String dir, Color background)
	{
		if (dir.equals("LEFT"))
		{
			setDirection("LEFT");
			head.moveAndDraw(window, dir, background);
			torso.moveAndDraw(window, dir, background);
			legs.moveAndDraw(window, dir, background);
		}
		else if (dir.equals("RIGHT"))
		{
			head.moveAndDraw(window, dir, background);
			torso.moveAndDraw(window, dir, background);
			legs.moveAndDraw(window, dir, background);
		}
		else if (dir.equals("UP"))
		{
			head.moveAndDraw(window, dir, background);
			torso.moveAndDraw(window, dir, background);
			legs.moveAndDraw(window, dir, background);
		}
		else
		{
			System.out.println("Movement Direction DNE");
		}
	}
	
}
