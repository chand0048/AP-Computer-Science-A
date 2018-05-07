package javaProjectTareetria;

import java.awt.Color;

public class Monster extends Humanoid
{
	public Monster(int x, int y)
	{
		this(x, y, 0, 0, "RIGHT", new Color(255, 255, 180), Color.RED, new Color(153, 51, 0));
	}
	public Monster(int x, int y, int xS, int yS, String d, Color headCol, Color torsoCol, Color legsCol)
	{
		super(x, y, 20, 80, xS, yS, d, headCol, torsoCol, legsCol);
	}
}
