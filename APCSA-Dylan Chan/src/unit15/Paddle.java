package unit15;


import java.awt.Color;
import java.awt.Graphics;


public class Paddle extends Block implements Collidable
{
	// instance variables
	private int speed;

	public Paddle()
	{
		super(10, 10);
		speed = 5;
	}

	// add the other Paddle constructors

	public Paddle(int x, int y)
	{
		super(x, y);
		speed = 5;
	}

	public Paddle(int x, int y, int s)
	{
		super(x, y);
		speed = s;
	}

	public Paddle(int x, int y, int w, int h)
	{
		super(x, y, w, h);
		speed = 5;
	}

	public Paddle(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed = s;
	}

	public Paddle(int x, int y, int w, int h, Color col)
	{
		super(x, y, w, h, col);
		speed = 5;
	}

	public Paddle(int x, int y, int w, int h, Color col, int s)
	{
		super(x, y, w, h, col);
		speed = s;
	}

	public void moveUpAndDraw(Graphics window)
	{
		super.draw(window, Color.WHITE);

		setY(getY() - getSpeed());

		super.draw(window);
	}

	public void moveDownAndDraw(Graphics window)
	{
		super.draw(window, Color.WHITE);

		setY(getY() + getSpeed());

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
				&& this.getY() >= temp.getY() && this.getY() <= temp.getY() + temp.getHeight())
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	// add get methods

	public int getSpeed()
	{
		return speed;
	}

	// add a toString() method
	public String toString()
	{
		String output = "";
		output += super.toString() + speed + " ";
		return output;
	}
}
