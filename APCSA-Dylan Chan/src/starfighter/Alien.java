package starfighter;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;


public class Alien extends MovingThing
{
	private int speed;
	private Image image;
	private String direction;
	
	public Alien()
	{
		this(0, 0, 0, "RIGHT");
	}
	
	public Alien(int x, int y)
	{
		this(x, y, 0, "RIGHT");
	}
	
	public Alien(int x, int y, int s, String dir)
	{
		super(x, y);
		speed = s;
		setDirection(dir);
		try
		{
			image = ImageIO.read(new File("src\\starfighter\\alien.png"));
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void setSpeed(int s)
	{
		speed = s;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public void setDirection(String dir)
	{
		direction = dir;
	}
	
	public String getDirection()
	{
		return direction;
	}
	
	public void draw(Graphics window)
	{
		window.drawImage(image, getX(), getY(), 50, 50, null);
	}
	
	public String toString()
	{
		String output = "";
		output += getX() + " " + getY() + " " + getSpeed();
		return output;
	}
}
