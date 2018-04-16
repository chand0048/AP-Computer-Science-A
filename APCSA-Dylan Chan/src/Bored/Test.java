package Bored;

import java.util.ArrayList;
import java.util.List;

public class Test
{
	public  static void changeit(int[] arr, int val, String word) {  arr=  new int[5]; val=  0; word=  word.substring(0, 5); for (int k  = 0;  k  < arr.length; k++) { arr[k] =  0;} } public  static void start() { int [ ]   nums = { 1 , 2 ,  3 , 4,  5} ; int value=  6; String name =  "blackboard"; changeit(nums, value, name); for (int k  = 0;  k  < nums.length; k++) { System.out.print(nums[k] +  " "); } System.out.print(value  + " " );System.out.print(name); }
	public static void main(String[] args)
	{
		List<String> students=  new ArrayList<String>(); students .add( "Alex"); students. add ("Bob") ; students.add("Carl"); for  (int k  = 0;  k  <   students.size(); k++) { System.out.print(students.set(k, "Alex") +  " "); } System.out.println(); for  (String str:  students) { System.out.print(str +" "); } 
	}
}
