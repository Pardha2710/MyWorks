package assignment7;

import java.util.*;

public class Rectangle
{
	double length,breadth;
	Rectangle(double length,double breadth)
	{
		this.length=length;
		this.breadth=breadth;
	} 
	void area()
	{
		System.out.println("Area of the Rectangle is: "+length*breadth);
	} 
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Length and Breadth of the Recatangle:");
		Rectangle r=new Rectangle(s.nextDouble(),s.nextDouble());
		r.area();	
	}
}