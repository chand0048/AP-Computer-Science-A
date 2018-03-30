package unit15;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


class SpeedUpBall extends Ball
{
	
	// instance variables
	
	public SpeedUpBall()
	{
		super();
	}
	
	public SpeedUpBall(int x, int y)
	{
		super(x, y);
	}
	
	public SpeedUpBall(int x, int y, int xSpd, int ySpd)
	{
		super(x, y, xSpd, ySpd);
	}
	
	public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
	{
		super(x, y, wid, ht, Color.BLACK, xSpd, ySpd);
	}
	
	public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
	{
		super(x, y, wid, ht, col, xSpd, ySpd);
	}
	
	public void setXSpeed(int xSpd)
	{
		super.setXSpeed(xSpd);
	}
	
	public void setYSpeed(int ySpd)
	{
		super.setYSpeed(ySpd);
	}
	
	public boolean didCollideRight(Object obj)
	{
		Block temp = (Block) obj;
		
		if (this.getX() >= temp.getX() && this.getX() <= temp.getX() + temp.getWidth()
				&& this.getY() >= temp.getY()
				&& this.getY() <= temp.getY() + temp.getHeight() - this.getHeight())
		{
			setXSpeed(super.getXSpeed() - 1);
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
			setXSpeed(super.getXSpeed() + 1);
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
			setYSpeed(super.getYSpeed() + 1);
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
			setYSpeed(super.getYSpeed() - 1);
			return true;
		}
		else
		{
			return false;
		}
	}}
