package unit11;

public class Time 
{
	private int hours, minutes, seconds;
	
	public Time()
	{
		long timeElapsed = System.currentTimeMillis() / 1000;
		setTime(timeElapsed);	
	}
	
	public Time(long elapseTime)
	{
		setTime(elapseTime);
	}
	
	public Time(int hour, int min, int sec)
	{
		hours = hour;
		minutes = min;
		seconds = sec;
	}
	
	public int getHours()
	{
		return hours;
	}
	
	public int getMins()
	{
		return minutes;
	}
	
	public int getSecs()
	{
		return seconds;
	}
	
	public void setTime(long elapseTime)
	{
		double timeElapsed = elapseTime;
		seconds = (int) timeElapsed % 60;
		timeElapsed /= 60;
		minutes = (int) timeElapsed % 60;
		timeElapsed /= 60;
		hours = (int) timeElapsed % 24;
	}
	
	public String toString()
	{
		return (hours - 7) + ":" + minutes + ":" + seconds + "\n";
	}
	
	public static void main(String [] args)
	{
		Time test1 = new Time();
		System.out.println(test1);
		
		Time test2 = new Time(1520891659);
		System.out.println(test2);
		
		Time test3 = new Time(17, 56, 9);
		System.out.println(test3);
	}
}
