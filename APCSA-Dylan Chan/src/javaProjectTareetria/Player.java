package javaProjectTareetria;


import java.awt.Color;


public class Player extends Humanoid
{
	private int health;
	private int jumpHeight;
	private boolean falling;

	public Player()
	{
		super();
		setHealth(100);
		setJumpHeight(15);
		setFalling(true);
	}
	
	public Player(int xPos, int yPos, int width, int height, int xSpeed, int ySpeed, String direction, Color headCol,
			Color torsoCol, Color legsCol, int h, int jHeight, boolean f)
	{
		super(xPos, yPos, width, height, xSpeed, ySpeed, direction, headCol, torsoCol, legsCol);
		setHealth(h);
		setJumpHeight(jHeight);
		setFalling(f);
	}

	public void setHealth(int h)
	{
		health = h;
	}

	public void setJumpHeight(int l)
	{
		jumpHeight = l;
	}
	
	public void setFalling(boolean f)
	{
		falling = f;
	}

	public int getHealth()
	{
		return health;
	}

	public int getJumpHeight()
	{
		return jumpHeight;
	}
	
	public boolean getFalling()
	{
		return falling;
	}
}
