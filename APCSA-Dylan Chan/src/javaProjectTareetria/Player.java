package javaProjectTareetria;


import java.awt.Color;


public class Player extends Humanoid
{
	private int health;
	private int jumpHeight;

	public Player()
	{
		super();
		setJumpHeight(10);
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
