package unit15;


import java.awt.Color;
import java.awt.Graphics;


public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;
	
	public Ball()
	{
		super(200, 200);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	// add the other Ball constructors
	
	public Ball(int x, int y)
	{
		super(x, y);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball(int x, int y, int w, int h)
	{
		super(x, y, w, h);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball(int x, int y, int w, int h, Color col)
	{
		super(x, y, w, h, col);
		setXSpeed(3);
		setYSpeed(1);
	}
	
	public Ball(int x, int y, int w, int h, Color col, int horizontal, int vertical)
	{
		super(x, y, w, h, col);
		setXSpeed(horizontal);
		setYSpeed(vertical);
	}
	
	// add the set methods
	
	public void setXSpeed(int horizontal)
	{
		xSpeed = horizontal;
	}
	
	public void setYSpeed(int vertical)
	{
		ySpeed = vertical;
	}
	
	public void moveAndDraw(Graphics window)
	{
		// draw a white ball at old ball location
		super.draw(window, Color.WHITE);
		
		setX(getX() + getXSpeed());
		// setY
		setY(getY() + getYSpeed());
		
		// draw the ball at its new location
		super.draw(window);
	}
	
	public boolean didCollideRight(Object obj)
	{
		Block temp = (Block) obj;
		
		if (this.getX() >= temp.getX() && this.getX() <= temp.getX() + temp.getWidth()
				&& this.getY() >= temp.getY()
				&& this.getY() <= temp.getY() + temp.getHeight() - this.getHeight())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean didCollideLeft(Object obj)
	{
		Block temp = (Block) obj;
		
		if (this.getX() >= temp.getX() - this.getWidth()
				&& this.getX() <= temp.getX() + temp.getWidth() - this.getWidth()
				&& this.getY() >= temp.getY()
				&& this.getY() <= temp.getY() + temp.getHeight() - this.getHeight())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean didCollideTop(Object obj)
	{
		Block temp = (Block) obj;
		
		if (this.getX() >= temp.getX()
				&& this.getX() <= temp.getX() + temp.getWidth() - this.getWidth()
				&& this.getY() <= temp.getY() + temp.getHeight() - this.getHeight()
				&& this.getY() >= temp.getY() - this.getHeight())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean didCollideBottom(Object obj)
	{
		Block temp = (Block) obj;
		
		if (this.getX() >= temp.getX()
				&& this.getX() <= temp.getX() + temp.getWidth() - this.getWidth()
				&& this.getY() >= temp.getY()
				&& this.getY() <= temp.getY() + temp.getHeight())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean equals(Object obj)
	{
		Ball temp = (Ball) obj;
		
		if (super.equals(obj) && this.getXSpeed() == temp.getXSpeed()
				&& this.getYSpeed() == temp.getYSpeed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// add the get methods
	
	public int getXSpeed()
	{
		return xSpeed;
	}
	
	public int getYSpeed()
	{
		return ySpeed;
	}
	// add a toString() method
	
	public String toString()
	{
		String output = "";
		output += super.toString() + getXSpeed() + " " + getYSpeed() + " ";
		return output;
	}
}
