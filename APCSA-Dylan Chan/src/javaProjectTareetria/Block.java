package javaProjectTareetria;


import java.awt.*;


public class Block implements Locatable, Collidable
{
	private int xPos, yPos, width, height, xSpeed, ySpeed;
	
	private Color color;
	
	public Block()
	{
		this(0, 0, 100, 100, 1, 1, Color.BLACK);
	}
	
	public Block(int x, int y)
	{
		this(x, y, 100, 100, 1, 1, Color.BLACK);
	}
	
	public Block(int x, int y, int w, int h)
	{
		this(x, y, w, h, 1, 1, Color.BLACK);
	}
	
	public Block(int x, int y, int w, int h, int xS, int yS)
	{
		this(x, y, w, h, xS, yS, Color.BLACK);
	}
	
	public Block(int x, int y, int w, int h, int xS, int yS, Color c)
	{
		setPos(x, y);
		setDimensions(w, h);
		setSpeed(xS, yS);
		setColor(c);
	}
	
	public void setX(int x)
	{
		xPos = x;
	}
	
	public void setY(int y)
	{
		yPos = y;
	}
	
	public void setPos(int x, int y)
	{
		setX(x);
		setY(y);
	}
	
	public void setWidth(int w)
	{
		width = w;
	}
	
	public void setHeight(int h)
	{
		height = h;
	}
	
	public void setDimensions(int w, int h)
	{
		setWidth(w);
		setHeight(h);
	}
	
	public void setXSpeed(int xS)
	{
		xSpeed = xS;
	}
	
	public void setYSpeed(int yS)
	{
		ySpeed = yS;
	}
	
	public void setSpeed(int xS, int yS)
	{
		setXSpeed(xS);
		setYSpeed(yS);
	}
	
	public void setColor(Color c)
	{
		color = c;
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
	
	public int getXSpeed()
	{
		return xSpeed;
	}
	
	public int getYSpeed()
	{
		return ySpeed;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void draw(Graphics window)
	{
		window.setColor(getColor());
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public void draw(Graphics window, Color c)
	{
		window.setColor(c);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public void moveAndDraw(Graphics window, String dir, Color background)
	{
		if (dir.equals("LEFT"))
		{
			draw(window, background);
			setX(getX() - getXSpeed());
			draw(window);
		}
		else if (dir.equals("RIGHT"))
		{
			draw(window, background);
			setX(getX() + getXSpeed());
			draw(window);
		}
		else if (dir.equals("UP"))
		{
			draw(window, background);
			setY(getY() - getYSpeed());
			draw(window);
		}
		else if (dir.equals("DOWN"))
		{
			draw(window, background);
			setY(getY() + getYSpeed());
			draw(window);
		}
		else
		{
			System.out.println("Movement Direction DNE");
		}
	}
	
	public void fallAndDraw(Graphics window, int speed, Color background)
	{
		draw(window, background);
		setY(getY() + speed);
		draw(window);
	}
	
	public String didCollide(Object obj)
	{
		Block temp = (Block) obj;
		
		if (this.getX() <= temp.getX() + temp.getWidth() && this.getX() >= temp.getX()
				&& this.getY() + this.getHeight() >= temp.getY()
				&& this.getY() <= temp.getY() + temp.getHeight())
		{
			return "LEFT";
		}
		else if (this.getX() + this.getWidth() >= temp.getX()
				&& this.getX() + this.getWidth() <= temp.getX() + temp.getWidth()
				&& this.getY() + this.getHeight() >= temp.getY()
				&& this.getY() <= temp.getY() + temp.getHeight())
		{
			return "RIGHT";
		}
		else if (this.getX() + this.getWidth() >= temp.getX()
				&& this.getX() <= temp.getX() + temp.getWidth()
				&& this.getY() <= temp.getY() + temp.getWidth()
				&& this.getY() >= temp.getY())
		{
			return "TOP";
		}
		else if (this.getX() + this.getWidth() >= temp.getX()
				&& this.getX() <= temp.getX() + temp.getWidth()
				&& this.getY() + this.getHeight() >= temp.getY()
				&& this.getY() + this.getX() <= temp.getY() + temp.getHeight())
		{
			return "BOTTOM";
		}
		else
		{
			return "NONE";
		}
	}
	
}
