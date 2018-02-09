package unit1;

import javax.swing.JFrame;

public class GraphicsRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public GraphicsRunner()
	{
		super("Graphics Runner");
		
		setSize(WIDTH,HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	public void runSmileyFace()
	{
		getContentPane().add(new SmileyFace());
	}
	
	public void runRobot()
	{
		getContentPane().add(new Robot());
	}
	
	public void runShapes()
	{
		getContentPane().add(new ShapePanel());
	}
	
	public static void main( String args[] )
	{
		GraphicsRunner run1 = new GraphicsRunner();
		run1.runSmileyFace();
		
		GraphicsRunner run2 = new GraphicsRunner();
		run2.runRobot();
		
		GraphicsRunner run3 = new GraphicsRunner();
		run3.runShapes();
	}
}
