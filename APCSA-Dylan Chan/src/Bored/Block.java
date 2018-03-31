package Bored;


import java.awt.Color;
import java.awt.Graphics;
import unit15.Locatable;


public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	
	private Color color;
	private boolean visible;
	
	public Block()
	{
		setPos(100, 150);
		setWidth(10);
		setHeight(10);
		setColor(Color.BLACK);
		setVisible(true);
	}
	
	// add other Block constructors - x , y , width, height, color
	public Block(int x, int y)
	{
		setPos(x, y);
		setWidth(10);
		setHeight(10);
		setColor(Color.BLACK);
		setVisible(true);
	}
	
	public Block(int x, int y, int w, int h)
	{
		setPos(x, y);
		setWidth(w);
		setHeight(h);
		setColor(Color.BLACK);
		setVisible(true);
	}
	
	public Block(int x, int y, int w, int h, Color col)
	{
		setPos(x, y);
		width = w;
		setWidth(w);
		setHeight(h);
		setColor(col);
		setVisible(true);
	}
	
	
	// add the other set methods
	public void setPos(int x, int y)
	{
		setX(x);
		setY(y);
	}
	
	public void setX(int x)
	{
		xPos = x;
	}
	
	public void setY(int y)
	{
		yPos = y;
	}
	
	public void setWidth(int w)
	{
		width = w;
	}
	
	public void setHeight(int h)
	{
		height = h;
	}
	
	public void setColor(Color col)
	{
		color = col;
	}
	
	public void setVisible(boolean visi)
	{
		if (visi == true)
		{
			visible = true;
		}
		else
		{
			visible = false;
		}
	}
	
	public void draw(Graphics window)
	{
		// uncomment after you write the set and get methods
		if (getVisible() == true)
		{
			window.setColor(color);
			window.fillRect(getX(), getY(), getWidth(), getHeight());
		}
		else
		{
			window.setColor(Color.WHITE);
			window.fillRect(getX(), getY(), getWidth(), getHeight());
		}
	}
	
	public void draw(Graphics window, Color col)
	{
		if (getVisible() == true)
		{
			window.setColor(col);
			window.fillRect(getX(), getY(), getWidth(), getHeight());
		}
		else
		{
			window.setColor(Color.WHITE);
			window.fillRect(getX(), getY(), getWidth(), getHeight());
		}
	}
	
	public boolean equals(Object obj)
	{
		Block temp = (Block) obj;
		
		if (this.getX() == temp.getX() && this.getY() == temp.getY()
				&& this.getWidth() == temp.getWidth()
				&& this.getHeight() == temp.getHeight()
				&& this.getColor() == temp.getColor())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	// add the other get methods
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
	
	public Color getColor()
	{
		return color;
	}
	
	public boolean getVisible()
	{
		return visible;
	}
	
	// add a toString() method - x , y , width, height, color
	
	public String toString()
	{
		String output = "";
		output += getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " "
				+ getColor() + " ";
		
		return output;
	}
}
