package javaProjectTareetria;


import java.awt.Color;


public class Player extends Humanoid
{
	private int health;
	private int jumpHeight;

	public Player()
	{
		super();
		setJumpHeight(15);
	}
	
	public Player(int xPos, int yPos, int width, int height, int xSpeed, int ySpeed, String direction, Color headCol,
			Color torsoCol, Color legsCol, int h, int jHeight)
	{
		super(xPos, yPos, width, height, xSpeed, ySpeed, direction, headCol, torsoCol, legsCol);
		setHealth(h);
		setJumpHeight(jHeight);
	}

	public void setHealth(int h)
	{
		health = h;
	}

	public void setJumpHeight(int l)
	{
		jumpHeight = l;
	}

	public int getHealth()
	{
		return health;
	}

	public int getJumpHeight()
	{
		return jumpHeight;
	}
}
