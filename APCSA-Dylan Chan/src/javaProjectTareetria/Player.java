package javaProjectTareetria;

import java.awt.Color;

public class Player extends Humanoid
{
	private int health;
	public Player()
	{
		super();
	}
	public void setHealth(int h)
	{
		health = h;
	}
	public int getHealth()
	{
		return health;
	}
}
