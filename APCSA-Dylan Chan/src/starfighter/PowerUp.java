package starfighter;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;


public class PowerUp implements Locatable
{
	private boolean visible;
	private int xPos, yPos;
	private Image image;
	
	public PowerUp(int x, int y, boolean v)
	{
		setPos(x, y);
		setVisible(v);
		try
		{
			image = ImageIO.read(new File("src\\starfighter\\pu.jpg"));
		}catch (Exception e)
		{
			System.out.println(e);
		}
	}
	public void setPos(int x, int y)
	{
		setX(x);
		setY(y);
	}

	public void setX(int x)
	{
		xPos = x;
	}

	public void setY(int y)
	{
		yPos = y;
	}
	
	public void setVisible(boolean v)
	{
		visible = v;
	}
	public int getX()
	{
		return xPos;
	}

	public int getY()
	{
		return yPos;
	}
	
	public boolean getVisible()
	{
		return visible;
	}
	
	public void draw(Graphics window)
	{
		window.drawImage(image, getX(), getY(), 50, 50, null);
	}
}
