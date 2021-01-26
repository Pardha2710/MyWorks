package assignment2;

import java.util.*;

public class AgeFinder{

public static void main(String args[])
{
  	System.out.println("Enter the age of a person to check wheather Major/Minor:");
	Scanner s=new Scanner(System.in);
	int age=s.nextInt();
	if(age>0)
	{
		if(age>=18)
		{
			System.out.println("The Person is a Major!");
		}
		else
		{
			System.out.println("The Person is a Minor!");
		}
		
	}
	else
	{
		System.out.println("Invalid Age!");
	}

}
}
