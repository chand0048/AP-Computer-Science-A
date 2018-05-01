package starfighter;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;


public class Ship extends MovingThing
{
	private int speed;
	private Image image;
	
	public Ship()
	{
		this(0, 0, 0);
	}
	
	public Ship(int x, int y)
	{
		this(x, y, 0);
	}
	
	public Ship(int x, int y, int s)
	{
		super(x, y);
		speed = s;
		setImage(new File("src\\starfighter\\ship.png"));
	}
	
	public void setImage(File f)
	{
		try
		{
			image = ImageIO.read(f);
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
	
	public void draw(Graphics window)
	{
		window.drawImage(image, getX(), getY(), 40, 70, null);
	}
	
	public String toString()
	{
		return super.toString() + " " + getSpeed();
	}
}
