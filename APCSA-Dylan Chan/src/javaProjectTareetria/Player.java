package javaProjectTareetria;


import java.awt.Color;


public class Player extends Humanoid
{
	private int health;
	private int jumpHeight;
	private boolean falling;
	private String moving;
	
	public Player()
	{
		this(400, 400, 20, 80, 0, 0, "RIGHT", new Color(255, 255, 180), Color.BLUE,
				new Color(153, 51, 0), 100, 15, false, "NONE");
	}
	
	public Player(int xPos, int yPos, int width, int height, int xSpeed, int ySpeed,
			String direction, Color headCol, Color torsoCol, Color legsCol, int h,
			int jHeight, boolean f, String m)
	{
		super(xPos, yPos, width, height, xSpeed, ySpeed, direction, headCol, torsoCol,
				legsCol);
		setHealth(h);
		setJumpHeight(jHeight);
		setFalling(f);
		setMoving(m);
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
	
	public void setMoving(String m)
	{
		moving = m;
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
	
	public String getMoving()
	{
		return moving;
	}
}
