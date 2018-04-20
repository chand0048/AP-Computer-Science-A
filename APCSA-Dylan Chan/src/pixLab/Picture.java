package pixLab;


import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List


/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture()
	{
		/*
		 * not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName)
	{
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width)
	{
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture)
	{
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image)
	{
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName,
	 *         height and width.
	 */
	public String toString()
	{
		String output = "Picture, filename " + getFileName() + " height " + getHeight()
				+ " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void zeroBlue()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
			}
		}
	}

	public void keepOnlyBlue()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}

	public void keepOnlyRed()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
				pixelObj.setGreen(0);
			}
		}
	}

	public void keepOnlyGreen()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
				pixelObj.setRed(0);
			}
		}
	}

	public void negate()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setRed(255 - pixelObj.getBlue());
				pixelObj.setRed(255 - pixelObj.getGreen());
			}
		}
	}

	public void grayscale()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				int average = (pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen())
						/ 3;
				pixelObj.setRed(average);
				pixelObj.setBlue(average);
				pixelObj.setGreen(average);
			}
		}
	}

	public void fixUnderwater()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setRed(pixelObj.getRed() + 60);
				pixelObj.setBlue(pixelObj.getBlue() - 80);
				pixelObj.setGreen(pixelObj.getGreen() - 80);

			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of
	 * the picture from left to right
	 */
	public void mirrorVertical()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width / 2; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorVerticalRightToLeft()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++)
		{
			for (int col = 0; col < width / 2; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	public void mirrorHorizontal()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height / 2; row++)
		{
			for (int col = 0; col < pixels[0].length; col++)
			{
				topPixel = pixels[row][col];
				bottomPixel = pixels[height - 1 - row][col];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorHorizontalBotToTop()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height / 2; row++)
		{
			for (int col = 0; col < pixels[0].length; col++)
			{
				topPixel = pixels[row][col];
				bottomPixel = pixels[height - 1 - row][col];
				topPixel.setColor(bottomPixel.getColor());
			}
		}
	}

	public void mirrorDiagonal()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel topRightPixel = null;
		Pixel bottomLeftPixel = null;
		int height = pixels.length;
		int width = pixels[0].length;

		if (height <= width)
		{
			for (int row = 0; row < height; row++)
			{
				for (int col = 0; col < height; col++)
				{
					topRightPixel = pixels[row][col];
					bottomLeftPixel = pixels[col][row];
					topRightPixel.setColor(bottomLeftPixel.getColor());
				}
			}
		}
		else
		{
			for (int row = 0; row < width; row++)
			{
				for (int col = 0; col < width; col++)
				{
					topRightPixel = pixels[row][col];
					bottomLeftPixel = pixels[col][row];
					topRightPixel.setColor(bottomLeftPixel.getColor());
				}
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple()
	{
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++)
		{
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
				count++;
			}
		}
		System.out.println(count);
	}

	public void mirrorArms()
	{
		int mirrorPoint = 220;
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		for (int row = 157; row < 197; row++)
		{
			for (int col = 103; col < 171; col++)
			{
				topPixel = pixels[row][col];
				bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col - 6];
				bottomPixel.setColor(topPixel.getColor());
			}
			for (int col = 238; col < 294; col++)
			{
				topPixel = pixels[row][col];
				bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col + 6];
				bottomPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorGull()
	{
		int mirrorPoint = 220;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		for (int row = 234; row < 306; row++)
		{
			for (int col = 235; col < 346; col++)
			{
				rightPixel = pixels[row][col];
				leftPixel = pixels[row - 13][mirrorPoint - (col - mirrorPoint)];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in
	 * the current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol)
	{
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++)
		{
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++)
			{
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	public void copy(Picture fromPic, int startRow, int startCol, int fromStartRow,
			int fromEndRow, int fromStartCol, int fromEndCol)
	{
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = fromStartRow, toRow = startRow; fromRow < fromEndRow
				&& toRow < toPixels.length; fromRow++, toRow++)
		{
			for (int fromCol = fromStartCol, toCol = startCol; fromCol < fromEndCol
					&& toCol < toPixels[0].length; fromCol++, toCol++)
			{
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	/** Method to create a collage of several pictures */
	public void createCollage()
	{
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}

	public void createMyCollage()
	{
		Picture seagull = new Picture("seagull.jpg");
		Picture snowman = new Picture("snowman.jpg");
		Picture palmTree = new Picture("beach.jpg");

		seagull.mirrorHorizontalBotToTop();

		this.copy(seagull, 0, 0, 156, 327, 235, 344);
		this.copy(snowman, 100, 125, 78, 298, 104, 294);
		this.copy(palmTree, 325, 270, 166, 239, 236, 405);
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist)
	{
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel bottomPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color rightColor = null;
		Color bottomColor = null;
		for (int row = 0; row < pixels.length - 1; row++)
		{
			for (int col = 0; col < pixels[0].length - 1; col++)
			{
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][col + 1];
				bottomPixel = pixels[row + 1][col];

				rightColor = rightPixel.getColor();
				bottomColor = bottomPixel.getColor();

				if (leftPixel.colorDistance(rightColor) > edgeDist
						|| leftPixel.colorDistance(bottomColor) > edgeDist)
					leftPixel.setColor(Color.BLACK);
				else
					leftPixel.setColor(Color.WHITE);
			}
		}
	}

	public void edgeDetection2(int edgeDist)
	{

		Pixel[][] pixels = this.getPixels2D();

		for (int row = 0; row < pixels.length - 1; row++)
		{
			for (int col = 0; col < pixels[0].length - 1; col++)
			{
				if (pixels[row][col].colorDistance(pixels[row + 1][col + 1].getColor()) > edgeDist)
					pixels[row][col].setColor(Color.BLACK);
				else
					pixels[row][col].setColor(Color.WHITE);
			}
		}
	}
	
	public void blur(int x, int y, int width, int height)
	{
		Pixel[][] pixels = this.getPixels2D();
		int averageRed = 0, averageGreen = 0, averageBlue = 0;
		
		if (y + height > pixels.length)
		{
			height = pixels.length - y - 1;
		}
		if (width > pixels[0].length)
		{
			width = pixels[0].length - x - 1;
		}
		

		for (int row = 0; row < height - 1; row++)
		{
			for (int col = 0; col < width - 1; col++)
			{
				Pixel pixel = pixels[y + row][x + col];
				Pixel rightPixel = pixels[y + row][x + col + 1];
				Pixel bottomPixel = pixels[y + row + 1][x + col];
				Pixel bottomRightPixel = pixels[y + row + 1][x + col + 1];
				
				averageRed = (pixel.getRed() + rightPixel.getRed() + bottomPixel.getRed() + bottomRightPixel.getRed()) / 4;
				averageGreen = (pixel.getGreen() + rightPixel.getGreen() + bottomPixel.getGreen() + bottomRightPixel.getGreen()) / 4;
				averageBlue = (pixel.getBlue() + rightPixel.getBlue() + bottomPixel.getBlue() + bottomRightPixel.getBlue()) / 4;
				
				pixel.setRed(averageRed);
				pixel.setGreen(averageGreen);
				pixel.setBlue(averageBlue);
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args)
	{
		Picture beach = new Picture("beach.jpg");
		Picture snowman = new Picture("snowman.jpg");
		Picture seagull = new Picture("seagull.jpg");
		beach.explore();
		snowman.explore();
		seagull.explore();
		// beach.zeroBlue();

	}

} // this } is the end of class Picture, put all new methods before this
