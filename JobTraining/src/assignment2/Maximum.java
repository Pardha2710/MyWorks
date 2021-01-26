package assignment2;

import java.util.*;

public class Maximum
{
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Please Enter 3 numbers to find the Maximum:");
		int num1=s.nextInt();
		int num2=s.nextInt();
		int num3=s.nextInt();

		int result= (num1>num2)?(num1>num3?num1:num3):(num2>num3?num2:num3);
		
		System.out.println("The Maxiumum among "+num1+","+num2+","+num3+" is:"+result);

	}
}