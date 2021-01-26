package assignment2;

import java.util.*;

public class LeapYear{

public static void main(String args[])
{
  	System.out.println("Please Enter the Year in YYYY format to check Leap Year:");
	Scanner s=new Scanner(System.in);
	int year=s.nextInt();
	if(year>0)
	{
		if(year%4==0)
		{
			System.out.println("It is a Leap Year!");
		}
		else
		{
			System.out.println("It is not a Leap Year!");
		}
		
	}
	else
	{
		System.out.println("Invalid Year!");
	}

}
}
